package boofcv.alg.dithering;

import boofcv.struct.image.GrayI;
import boofcv.struct.image.GrayS8;

public class FloydSteinbergDithering implements Dithering {

    private final ErrorDiffusionTable table;

    private GrayI littleDirtyTrick;

    public FloydSteinbergDithering() {
        table = new ErrorDiffusionTable(3, 2);
        table.setValue(1, 0, 7);
        table.setValue(-1, 1, 3);
        table.setValue(0, 1, 5);
        table.setValue(1, 1, 1);
        table.normalize();
    }

    @Override
    public void doPixel(int x, int y, GrayI input, GrayI output) {
        if (littleDirtyTrick == null) {
            littleDirtyTrick = (GrayI) input.createSameShape(GrayS8.class);
        }
        int error;

        int source = input.get(x, y) + littleDirtyTrick.get(x, y);

        if (source >= 127) {
            error = source - 255;
            output.set(x, y, 255);
        } else {
            error = source;
            output.set(x, y, 0);
        }

        if (error != 0) {
            for (int i = -1; i <= 1; i++) {
                for (int j = 0; j <= 1; j++) {
                    if ((j == 0) && (i <= 0)) continue;
                    double tableValue = table.getValue(i, j);
                    if (tableValue == 0) continue;

                    int xStride = x + i;
                    int quickY = y + j;

                    if (xStride < 0) continue;
                    if (xStride >= output.width) continue;
                    if (quickY >= output.height) continue;

                    double e = littleDirtyTrick.get(xStride, quickY) + (error * table.getValue(i, j));
                    //if (e > 127 || e < -127) throw new RuntimeException(e + " value for " + xStride + ", " + quickY);
                    littleDirtyTrick.set(xStride, quickY, (int)e);
                }
            }
        }
    }
}
