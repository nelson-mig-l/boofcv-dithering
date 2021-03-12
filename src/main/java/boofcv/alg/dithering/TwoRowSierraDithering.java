package boofcv.alg.dithering;

public class TwoRowSierraDithering extends AbstractErrorDithering {

    /**
     *             X   4   3
     *     1   2   3   2   1
     *           (1/16)
     */
    public TwoRowSierraDithering() {
        super(new ErrorDiffusionTable(5, 2));
        table.setValue(1, 0, 4);
        table.setValue(2, 0, 3);
        table.setValue(-2, 1, 1);
        table.setValue(-1, 1, 2);
        table.setValue(0, 1, 3);
        table.setValue(1, 1, 2);
        table.setValue(2, 1, 1);
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
