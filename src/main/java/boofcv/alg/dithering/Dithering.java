package boofcv.alg.dithering;

import boofcv.struct.image.GrayU8;

public interface Dithering {

    void initialize(GrayU8 input);

    void nextLine(int y);

    int doPixel(int x, int y);

}
