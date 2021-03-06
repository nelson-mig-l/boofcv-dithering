package boofcv.alg.dithering;

import boofcv.struct.image.GrayU8;

import java.util.Random;

public class RandomDithering implements Dithering {

    private final Random random = new Random();

    @Override
    public GrayU8 apply(GrayU8 input) {
        GrayU8 output = input.createSameShape();
        for (int y = 0; y < input.height; y++) {
            for (int x = 0; x < input.width; x++) {
                int thresholdValue = random.nextInt(255);
                int source = input.get(x, y);
                if (source > thresholdValue) {
                    output.set(x, y, 255);
                } else {
                    output.set(x, y, 0);
                }
            }
        }
        return output;
    }

}
