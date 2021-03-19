package boofcv.alg.dithering;

import boofcv.struct.image.GrayU8;

import java.util.Random;

public class RandomDithering implements Dithering {

    private final Random random;

    private GrayU8 input;

    public RandomDithering() {
        random = new Random();
    }

    public RandomDithering(int seed) {
        random = new Random(seed);
    }

    @Override
    public void initialize(GrayU8 input) {
        this.input = input;
    }

    @Override
    public void nextLine(int y) {
        // do nothing
    }

    @Override
    public int doPixel(int x, int y) {
        int thresholdValue = random.nextInt(255);
        int source = input.get(x, y);
        if (source > thresholdValue) {
            return 255;
        } else {
            return 0;
        }
    }

}
