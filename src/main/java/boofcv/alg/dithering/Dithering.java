package boofcv.alg.dithering;

import boofcv.struct.image.GrayI;

public interface Dithering<T extends GrayI> {

    void doPixel(int x, int y, T input, T output);

}
