package boofcv.alg.dithering;

import boofcv.struct.image.GrayU8;

import java.util.Random;

public class SmartRandomDithering implements Dithering {

    private final Random random = new Random();

    private int error = 0;

    private GrayU8 input;

    @Override
    public void initialize(GrayU8 input) {
        this.input = input;
    }

    @Override
    public void nextLine(int y) {
        error = 0;
    }

    @Override
    public int doPixel(int x, int y) {
        final int source = input.get(x, y) + error;
        if (source > random.nextInt(255)) {
            error = source - 255;
            return 255;
        } else {
            error = source;
            return 0;
        }
    }
}
