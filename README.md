# "Random" Noise

**Audio-visualizations of pseudorandom number generators**

> "People have traditionally tended to avoid learning about such subroutines; old methods that were comparatively unsatisfactory have been passed down blindly from one programmer to another, until the users have no understanding of the original limitations." - Knuth Vol. 2

Useful applications of random numbers given in Knuth's introduction:

1. Simulation
2. Sampling
3. Numerical analysis
4. Computer programming
5. Decision making
6. Aesthetics
7. Recreation

The first time I heard of a [linear-feedback shift register](https://en.wikipedia.org/wiki/Linear-feedback_shift_register) was while reverse-engineering the noise channel of the audio processing unit [(APU)](https://wiki.nesdev.com/w/index.php/APU) of the Nintendo Entertainment System (NES). This method happens to produce some very interesting percussion sounds. Makes one wonder what other generators would sound like.

We shall implement the classic noise algorithms and... _listen_ to them.
