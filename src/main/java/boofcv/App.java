package boofcv;

import boofcv.alg.dithering.*;
import boofcv.io.image.ConvertBufferedImage;
import boofcv.io.image.UtilImageIO;
import boofcv.struct.image.GrayU8;

import java.awt.image.BufferedImage;
import java.io.File;

public class App {

    private static final String EXAMPLE = "docs/lena.bmp";

    public static void main(String[] args) {
        final File file = new File("");
        System.out.println(file.getAbsolutePath());

        final BufferedImage image = UtilImageIO.loadImage(EXAMPLE);
        final GrayU8 input = new GrayU8(image.getWidth(), image.getHeight());
        ConvertBufferedImage.convertFromSingle(image, input, GrayU8.class);
        UtilImageIO.saveImage(input, output("bw-ref"));

        apply(input, new FixedThreshold(), "no");
        apply(input, new SimpleDithering(), "simple");
        apply(input, new FloydSteinbergDithering(), "floyd-steinberg");
        apply(input, new JarvisJudiceAndNinkeDithering(), "jarvis-judice-and-ninke");
        apply(input, new StuckiDithering(), "stucki");
        apply(input, new AtkinsonDithering(), "atkinson");
        apply(input, new BurkesDithering(), "burkes");
        apply(input, new SierraDithering(), "sierra");
        apply(input, new TwoRowSierraDithering(), "two-row-sierra");
        apply(input, new SierraLiteDithering(), "sierra-lite");
        apply(input, new SimpleSerpentineDithering(), "simple-serpentine");
        apply(input, new RandomDithering(), "random");
    }

    private static void apply(final GrayU8 input, final Dithering dithering, final String name) {
        UtilImageIO.saveImage(dithering.apply(input), output(name));
    }

    private static String output(final String name) {
        return EXAMPLE.replace("lena", name);
    }
}
