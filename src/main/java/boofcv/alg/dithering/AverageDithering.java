package boofcv.alg.dithering;

import boofcv.struct.image.GrayU8;

public class AverageDithering implements Dithering {

    private static final int DEFAULT_THRESHOLD_VALUE = 127;

    private final int thresholdValue;

    private GrayU8 input;

    public AverageDithering() {
        this(DEFAULT_THRESHOLD_VALUE);
    }

    public AverageDithering(int thresholdValue) {
        this.thresholdValue = thresholdValue;
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
        final int source = input.get(x, y);
        if (source > thresholdValue) {
            return 255;
        } else {
            return 0;
        }
    }
}
