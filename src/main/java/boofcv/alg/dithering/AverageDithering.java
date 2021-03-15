package boofcv.alg.dithering;

import boofcv.struct.image.GrayU8;

public class AverageDithering implements Dithering {

    private static final int DEFAULT_THRESHOLD_VALUE = 127;

    private final int thresholdValue;

    public AverageDithering() {
        this(DEFAULT_THRESHOLD_VALUE);
    }

    public AverageDithering(int thresholdValue) {
        this.thresholdValue = thresholdValue;
    }


    GrayU8 input;

    @Override
    public void initialize(GrayU8 input) {
        this.input = input;
    }

    @Override
    public int doPixel(int x, int y) {
        final int source = input.get(x, y);
        if (source > thresholdValue) {
            //output.set(x, y, 255);
            return 255;
        } else {
            //output.set(x, y, 0);
            return 0;
        }
    }
}
