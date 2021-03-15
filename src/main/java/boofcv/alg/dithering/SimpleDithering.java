package boofcv.alg.dithering;

import boofcv.struct.image.GrayU8;

public class SimpleDithering implements Dithering {

    private int error = 0;
    private int lastY = 0;

    private GrayU8 input;

    @Override
    public void initialize(GrayU8 input) {
        this.input = input;
    }

    @Override
    public int doPixel(int x, int y) {
        if (lastY != y) { lastY = y; error = 0; } // little dirty hack
        int blackError = input.get(x, y) + error;
        int whiteError = blackError - 255;
        if (Math.abs(whiteError) > Math.abs(blackError)) {
            error = blackError;
            return 0;
        } else {
            error = whiteError;
            return 255;
        }
    }
}
