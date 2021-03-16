package boofcv.alg.dithering;

import boofcv.struct.image.GrayS8;
import boofcv.struct.image.GrayU8;

public class ErrorDiffusionDithering implements Dithering {

    private final ErrorDiffusionTable table;

    private GrayU8 input;
    private GrayS8 error;

    public ErrorDiffusionDithering(ErrorDiffusionTable table) {
        this.table = table;
    }

    @Override
    public void initialize(GrayU8 input) {
        this.input = input;
        this.error = input.createSameShape(GrayS8.class);
    }

    @Override
    public int doPixel(int x, int y) {
        int source = input.get(x, y) + error.get(x, y);
        if (source >= 127) {
            propagateError(x, y, source - 255);
            return 255;
        } else {
            propagateError(x, y, source);
            return 0;
        }
    }

    private void propagateError(int x, int y, int err) {
        if (err != 0) {
            for (int i = table.minX(); i <= table.maxX(); i++) {
                for (int j = table.minY(); j <= table.maxY(); j++) {
                    if ((j == 0) && (i <= 0)) continue;
                    double tableValue = table.getValue(i, j);
                    if (tableValue == 0) continue;

                    int xStride = x + i;
                    int quickY = y + j;

                    if (xStride < 0) continue;
                    if (xStride >= error.width) continue;
                    if (quickY >= error.height) continue;

                    double e = error.get(xStride, quickY) + (err * table.getValue(i, j));
                    error.set(xStride, quickY, (int)e);
                }
            }
        }
    }

}
