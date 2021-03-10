# Random dither

Random dithering could be termed the "bubblesort" of digital halftoning
algorithms.  It was the first attempt (documented as far back as 1951) to
correct the contouring produced by fixed thresholding, and it has
traditionally been referenced for comparison in most studies of digital
halftoning.  In fact, the name "ordered dither" (which will be discussed
later) was chosen to contrast random dither.

While it is not really acceptable as a production method, it is very simple
to describe and implement.  For each dot in our grayscale image, we generate
a random number in the range 0 - 255: if the random number is greater than
the image value at that dot, the display device plots the dot white;
otherwise, it plots it black.  That's it.

This generates a picture with a lot of "white noise", which looks like TV
picture "snow".  Although inaccurate and grainy, the image is free from
artifacts.  Interestingly enough, this digital halftoning method is useful
in reproducing very low-frequency images, where the absence of artifacts is
more important than noise.  For example, a whole screen containing a
gradient of all levels from black to white would actually look best with a
random dither.  With this image, other digital halftoning algorithms would
produce significant artifacts like diagonal patterns (in ordered dithering)
and clustering (in error diffusion halftones).

I should mention, of course, that unless your computer has a hardware-based
random number generator (and most don't), there may be some artifacts from
the random number generation algorithm itself.  For efficiency, you can take
the random number generator "out of the loop" by generating a list of random
numbers beforehand for use in the dither.  Make sure that the list is larger
than the number of dots in the image or you may get artifacts from the reuse
of numbers.  The worst case would be if the size of your list of random
numbers is a multiple or near-multiple of the horizontal size of the image;
in this case, unwanted vertical or diagonal lines will appear.

As unattractive as it is, random dithering can actually be related to a
pleasing, centuries-old art know as mezzotinting (the name itself is an
Italianized derivative of the English "halftone").  In a mezzotint, the
skilled craftsman worked a soft metal (usually copper) printing plate, and
roughened or ground the dark regions of the image by hand and in a seemingly
random fashion.  Analyzing it in scientific terms (which would surely insult
any mezzotinting artisan who might read this!) the pattern created is not
very regular or periodic at all, but the absence of low frequency noise
leads to a very attractive image without much graininess.  A similar process
is still in use today, in the form of modern gravure printing.

![original](bw-ref.bmp)
![processed](random.bmp)
