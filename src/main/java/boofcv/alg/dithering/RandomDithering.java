package boofcv.alg.dithering;

import boofcv.struct.image.GrayI;

import java.util.Random;

public class RandomDithering extends AbstractDithering {

    private final Random random = new Random();

    @Override
    public void doPixel(int x, int y) {
        int thresholdValue = random.nextInt(255);
        int source = input.get(x, y);
        if (source > thresholdValue) {
            output.set(x, y, 255);
        } else {
            output.set(x, y, 0);
        }
    }

}
