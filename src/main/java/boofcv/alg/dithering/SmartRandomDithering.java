package boofcv.alg.dithering;

import java.util.Random;

public class SmartRandomDithering extends AbstractDithering {

    private final Random random = new Random();

    private int error = 0;
    private int lastY = 0;

    @Override
    protected void doPixel(int x, int y) {
        if (lastY != y) {lastY = y; error = 0;} // little dirty hack
        final int source = input.get(x, y) + error;
        if (source > random.nextInt(255)) {
            output.set(x, y, 255);
            error = source - 255;
        } else {
            output.set(x, y, 0);
            error = source;
        }
    }
}
