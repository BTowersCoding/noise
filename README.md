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

While certain aspects of _noise_ (in its literal, _sonic_ sense) may occupy or express aspects of the above domains, I was surprised not to see it mentioned explicitly. Indeed, the first time I heard of a [linear-feedback shift register](https://en.wikipedia.org/wiki/Linear-feedback_shift_register) was while reverse-engineering the noise channel of the audio processing unit [(APU)](https://wiki.nesdev.com/w/index.php/APU) of the Nintendo Entertainment System (NES).

This is a delight, because if there could be even a chance of exploring a novel approach to generating random numbers, I could be just the person who is silly enough to try it. We shall implement the classic noise algorithms and... _listen_ to them.
