package boofcv.alg.dithering;

import boofcv.struct.image.GrayU8;

abstract class AbstractDithering implements Dithering {

    protected GrayU8 input;
    protected GrayU8 output;

    public GrayU8 apply(GrayU8 input) {
        this.input = input;
        this.output = input.createSameShape();

        for (int y = 0; y < input.height; y++) {
            for (int x = 0; x < input.width; x++) {
                this.doPixel(x, y);
            }
        }
        return output;
    }

    protected abstract void doPixel(int x, int y);

}
