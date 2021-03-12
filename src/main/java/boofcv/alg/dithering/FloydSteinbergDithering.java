package boofcv.alg.dithering;

public class FloydSteinbergDithering extends AbstractErrorDithering {

    public FloydSteinbergDithering() {
        super(new ErrorDiffusionTable(3, 2));
        table.setValue(1, 0, 7);
        table.setValue(-1, 1, 3);
        table.setValue(0, 1, 5);
        table.setValue(1, 1, 1);
        table.normalize();
    }

    @Override
    public void doPixel(int x, int y) {
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
