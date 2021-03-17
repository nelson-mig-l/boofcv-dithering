package boofcv.alg.dithering;

import boofcv.struct.image.GrayU8;

import java.util.Random;

public class GaussianRandomDithering implements Dithering {

    private final Random random;

    private GrayU8 input;

    public GaussianRandomDithering() {
        random = new Random();
    }

    @Override
    public void initialize(GrayU8 input) {
        this.input = input;
    }

    @Override
    public int doPixel(int x, int y) {
        int thresholdValue = nextGaussianThreshold();
        int source = input.get(x, y);
        if (source > thresholdValue) {
            return 255;
        } else {
            return 0;
        }
    }

    private int nextGaussianThreshold() {
        // Remember, that numbers returned by nextGaussian() will tend to
        // "cluster" around 0 with the above shape, and that
        // (approximately) 70% of values will be between -1 and 1.
        final double gaussian = random.nextGaussian();
        final double scaled = gaussian * 48 + 128;
        return clamp(scaled);
    }

    private int clamp(double value) {
        return (int) Math.round(Math.max(0, Math.min(255, value)));
    }
}
