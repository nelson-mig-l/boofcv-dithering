package boofcv.alg.dithering;

import boofcv.struct.image.GrayU8;
import boofcv.struct.image.Planar;

public class DitheringOperation {

    private final Dithering dithering;

    public DitheringOperation(Dithering dithering) {
        this.dithering = dithering;
    }

    public GrayU8 apply(GrayU8 input) {
        GrayU8 output = input.createSameShape();
        apply(input, output);
        return output;
    }

    public Planar<GrayU8> apply(Planar<GrayU8> input) {
        Planar<GrayU8> output = input.createSameShape();
        for (int i = 0; i < input.getNumBands(); i++) {
            apply(input.getBand(i), output.getBand(i));
        }
        return output;
    }

    private void apply(GrayU8 input, GrayU8 output) {
        dithering.initialize(input);
        for (int y = 0; y < input.height; y++) {
            dithering.nextLine(y);
            for (int x = 0; x < input.width; x++) {
                int value = dithering.doPixel(x, y);
                output.set(x, y, value);
            }
        }
    }

}
