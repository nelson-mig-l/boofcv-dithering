package boofcv.alg.dithering;

import boofcv.struct.image.GrayU8;

public class NoDithering implements Dithering {

    private static final int DEFAULT_THRESHOLD_VALUE = 127;

    private final int thresholdValue;

    public NoDithering() {
        this(DEFAULT_THRESHOLD_VALUE);
    }

    public NoDithering(int thresholdValue) {
        this.thresholdValue = thresholdValue;
    }

    @Override
    public GrayU8 apply(GrayU8 input) {
        GrayU8 output = input.createSameShape();
        for (int y = 0; y < input.height; y++) {
            for (int x = 0; x < input.width; x++) {
                final int source = input.get(x, y);
                if (source > thresholdValue) {
                    output.set(x, y, 255);
                } else {
                    output.set(x, y, 0);
                }
            }
        }
        return output;
    }

}
