package boofcv.alg.dithering;

import boofcv.struct.image.GrayU8;

public class DitheringOperation {

    public static GrayU8 apply(GrayU8 input, Dithering dithering) {
        GrayU8 output = input.createSameShape();
        for (int y = 0; y < input.height; y++) {
            for (int x = 0; x < input.width; x++) {
                dithering.doPixel(x, y, input, output);
            }
        }
        return output;
    }

}
