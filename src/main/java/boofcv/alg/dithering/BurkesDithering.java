package boofcv.alg.dithering;

public class BurkesDithering extends AbstractErrorDithering {


    /**
     *              X   8   4
     *      2   4   8   4   2
     */
    public BurkesDithering() {
        super(new ErrorDiffusionTable(5, 2));
        table.setValue(1, 0, 8);
        table.setValue(2, 0, 4);

        table.setValue(-2, 1, 2);
        table.setValue(-1, 1, 4);
        table.setValue(0, 1, 8);
        table.setValue(1, 1, 4);
        table.setValue(2, 1, 2);

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
