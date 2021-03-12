package boofcv.alg.dithering;

public class SierraLiteDithering extends AbstractErrorDithering {

    /**
     *             X   2
     *         1   1
     *           (1/4)
     */
    public SierraLiteDithering() {
        super(new ErrorDiffusionTable(3, 2));
        table.setValue(1, 0, 2);
        table.setValue(-1, 1, 1);
        table.setValue(0, 1, 1);
        table.normalize();
    }

    @Override
    protected void doPixel(int x, int y) {
        int err;
        int source = input.get(x, y) + error.get(x, y);
        if (source >= 127) {
            err = source - 255;
            output.set(x, y, 255);
        } else {
            err = source;
            output.set(x, y, 0);
        }
        propagateError(x, y, err);
    }
}
