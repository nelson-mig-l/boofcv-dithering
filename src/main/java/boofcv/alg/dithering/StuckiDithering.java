package boofcv.alg.dithering;

public class StuckiDithering extends AbstractErrorDithering {

    /**
     *              X   8   4
     *      2   4   8   4   2
     *      1   2   4   2   1
     */
    public StuckiDithering() {
        super(new ErrorDiffusionTable(5, 3));
        table.setValue(1, 0, 8);
        table.setValue(2, 0, 4);

        table.setValue(-2, 1, 2);
        table.setValue(-1, 1, 4);
        table.setValue(0, 1, 8);
        table.setValue(1, 1, 4);
        table.setValue(2, 1, 2);

        table.setValue(-2, 2, 1);
        table.setValue(-1, 2, 2);
        table.setValue(0, 2, 4);
        table.setValue(1, 2, 2);
        table.setValue(2, 2, 1);

        table.normalize();
    }

    private int err = 0;

    @Override
    protected void doPixel(int x, int y) {
        int source = input.get(x, y) + error.get(x, y);

        if (source >= 127) {
            err = source - 255;
            output.set(x, y, 255);
        } else {
            err = source;
            output.set(x, y, 0);
        }
        propagateError(x, y, err);
//        if (err != 0) {
//            for (int i = table.minX(); i <= table.maxX(); i++) {
//                for (int j = table.minY(); j <= table.maxY(); j++) {
//                    if ((j == 0) && (i <= 0)) continue;
//                    double tableValue = table.getValue(i, j);
//                    if (tableValue == 0) continue;
//
//                    int xStride = x + i;
//                    int quickY = y + j;
//
//                    if (xStride < 0) continue;
//                    if (xStride >= error.width) continue;
//                    if (quickY >= error.height) continue;
//
//                    double e = error.get(xStride, quickY) + (err * table.getValue(i, j));
//                    error.set(xStride, quickY, (int)e);
//                }
//            }
//        }
    }

}
