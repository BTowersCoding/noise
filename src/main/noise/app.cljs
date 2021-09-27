(ns noise.app
  (:require
   [reagent.core :as r]
   [reagent.dom :as d]))

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
  (let [source (.createBufferSource *context*)]
    (.resume *context*)
    (set! (.-buffer source) buffer)
    (.connect source (.-destination *context*))
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