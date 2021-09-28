(ns noise.app
  (:require
   [reagent.core :as r]
   [reagent.dom :as d]))

(defn middle-square [n]
  (let [len (count (str n))]
    (js/parseInt
     (subs (str (* n n))
           (/ len 2)
           (- (* len 2) (/ len 2))))))

(comment
  (* 8718 8718)
  (middle-square 8718)
  (take 50 (iterate middle-square 9418))
  )

(defonce ^:dynamic *context* (js/AudioContext.))

(defn audio-buffer [context duration]
  (let [sample-rate 44100
        frame-count (* sample-rate duration)
        buffer (.createBuffer context 1 frame-count sample-rate)
        data (.getChannelData buffer 0)]
    (doseq [i (range frame-count)]
      (aset data i (-> (js/Math.random) (* 2.0) (- 1.0))))
    buffer))

(defn buffer-source [buffer]
  (let [source (.createBufferSource *context*)
        gain (.createGain *context*)]
    (.resume *context*)
    (set! (.-buffer source) buffer)
    (.setValueAtTime (.-gain gain) 0.5 (.-currentTime *context*))
    (.connect source gain)
    (.connect gain (.-destination *context*))
    (.start source (.-currentTime *context*))
    source))

(defn button [label onclick]
  [:button
   {:on-click onclick}
   label])

(defn home-page []
  [:div [button "Noise"
         #(buffer-source (audio-buffer *context* 1.0))]])

;; -------------------------
;; Initialize app

(defn mount-root []
  (d/render [home-page] (.getElementById js/document "root")))

(defn ^:export init []
  (mount-root))