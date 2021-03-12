# The Floyd-Steinberg filter

This is where it all began, with Floyd and Steinberg's [4] pioneering
research in 1975.  The filter can be diagrammed thus:

```
          *   7
      3   5   1     (1/16)
```

In this (and all subsequent) filter diagrams, the "*" represents the pixel
currently being scanning, and the neighboring numbers (called weights)
represent the portion of the error distributed to the pixel in that
position.  The expression in parentheses is the divisor used to break up the
error weights.  In the Floyd-Steinberg filter, each pixel "communicates"
with 4 "neighbors."  The pixel immediately to the right gets 7/16 of the
error value, the pixel directly below gets 5/16 of the error, and the
diagonally adjacent pixels get 3/16 and 1/16.

The weighting shown is for the traditional left-to-right scanning of the
image.  If the line were scanned right-to-left (more about this later), this
pattern would be reversed.  In either case, the weights calculated for the
subsequent line must be held by the program, usually in an array of some
sort, until that line is visited later.

Floyd and Steinberg carefully chose this filter so that it would produce a
checkerboard pattern in areas with intensity of 1/2 (or 128, in our sample
image).  It is also fairly easy to execute in programming code, since the
division by 16 is accomplished by simple, fast bit-shifting instructions
(this is the case whenever the divisor is a power of 2).

![original](bw-ref.bmp)
![processed](floyd-steinberg-ref.bmp)

[4]  Floyd, R.W. and L. Steinberg, "An Adaptive Algorithm for Spatial Gray
     Scale."  SID 1975, International Symposium Digest of Technical Papers,
     vol 1975m, pp. 36-37.
     Short article in which Floyd and Steinberg introduce their filter.