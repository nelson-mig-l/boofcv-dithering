package boofcv.alg.dithering;

import boofcv.struct.image.GrayS8;
import boofcv.struct.image.GrayU8;

public class ErrorDiffusionDithering extends AbstractDithering {

    private final ErrorDiffusionTable table;

    private GrayS8 error;

    public ErrorDiffusionDithering(ErrorDiffusionTable table) {
        this.table = table;
    }

    public GrayU8 apply(GrayU8 input) {
        error = input.createSameShape(GrayS8.class);
        return super.apply(input);
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

    protected void propagateError(int x, int y, int err) {
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
