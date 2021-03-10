package boofcv.alg.dithering;

import boofcv.struct.image.GrayI;
import boofcv.struct.image.GrayS32;
import boofcv.struct.image.GrayU8;

public abstract class ErrorDiffusionDithering implements Dithering {

    protected final ErrorDiffusionTable table;

    protected ErrorDiffusionDithering(ErrorDiffusionTable table) {
        this.table = table;
    }

    protected GrayU8 createOutput(GrayS32 target) {
        final GrayU8 output = target.createSameShape(GrayU8.class);
        for (int y = 0; y < target.height; y++) {
            for (int x = 0; x < target.width; x++) {
                output.set(x, y, target.get(x, y));
            }
        }
        return output;
    }

    protected GrayI newCreateOutput(GrayI target) {
        final GrayI output = (GrayI) target.createSameShape(GrayU8.class);
        for (int y = 0; y < target.height; y++) {
            for (int x = 0; x < target.width; x++) {
                output.set(x, y, target.get(x, y));
            }
        }
        return output;
    }

}
