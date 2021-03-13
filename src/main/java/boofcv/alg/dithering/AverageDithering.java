package boofcv.alg.dithering;

public class AverageDithering extends AbstractDithering {

    private static final int DEFAULT_THRESHOLD_VALUE = 127;

    private final int thresholdValue;

    public AverageDithering() {
        this(DEFAULT_THRESHOLD_VALUE);
    }

    public AverageDithering(int thresholdValue) {
        this.thresholdValue = thresholdValue;
    }

    @Override
    protected void doPixel(int x, int y) {
        final int source = input.get(x, y);
        if (source > thresholdValue) {
            output.set(x, y, 255);
        } else {
            output.set(x, y, 0);
        }
    }
}
