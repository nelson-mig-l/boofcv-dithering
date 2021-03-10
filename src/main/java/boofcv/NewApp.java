package boofcv;

import boofcv.alg.dithering.*;
import boofcv.io.image.ConvertBufferedImage;
import boofcv.io.image.UtilImageIO;
import boofcv.struct.image.GrayU8;

import java.awt.image.BufferedImage;

public class NewApp {

    private static final String EXAMPLE = "docs/lena.bmp";

    public static void main(String[] args) {
        final BufferedImage image = UtilImageIO.loadImage(EXAMPLE);
        final GrayU8 input = new GrayU8(image.getWidth(), image.getHeight());
        ConvertBufferedImage.convertFromSingle(image, input, GrayU8.class);
        UtilImageIO.saveImage(input, output("bw-ref"));

        apply(input, new FixedThreshold(), "no");
        apply(input, new RandomDithering(), "random");
        apply(input, new FloydSteinbergDithering(), "floyd-steinberg");
    }

    private static void apply(final GrayU8 input, final Dithering dithering, final String name) {
        final GrayU8 output = DitheringOperation.apply(input, dithering);
        UtilImageIO.saveImage(output, output(name));
    }

    private static String output(final String name) {
        return EXAMPLE.replace("lena", "new_" + name);
    }
}
