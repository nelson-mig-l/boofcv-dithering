package boofcv.alg.dithering;

import boofcv.struct.image.GrayI;
import boofcv.struct.image.GrayU8;

/**
 * Not really dithering.
 */
public class FixedThreshold implements Dithering {

    private static final int DEFAULT_THRESHOLD_VALUE = 127;

    private final int thresholdValue;

    public FixedThreshold() {
        this(DEFAULT_THRESHOLD_VALUE);
    }

    public FixedThreshold(int thresholdValue) {
        this.thresholdValue = thresholdValue;
    }


    @Override
    public void doPixel(int x, int y, GrayI input, GrayI output) {
        final int source = input.get(x, y);
        if (source > thresholdValue) {
            output.set(x, y, 255);
        } else {
            output.set(x, y, 0);
        }
    }
}
