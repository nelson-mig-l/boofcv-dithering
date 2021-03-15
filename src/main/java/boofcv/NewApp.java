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

        final DitheringFactory dithering = new DitheringFactory();

        apply(input, dithering.average(), "average");
        apply(input, dithering.random(), "random");
        apply(input, dithering.simple(), "simple");

        apply(input, dithering.errorDiffusion().floydSteinberg(), "floyd-steinberg");
        apply(input, dithering.errorDiffusion().stucki(), "stucki");
        apply(input, dithering.errorDiffusion().atkinson(), "atkinson");
        apply(input, dithering.errorDiffusion().burkes(), "burkes");
        apply(input, dithering.errorDiffusion().sierra(), "sierra");
        apply(input, dithering.errorDiffusion().twoRowSierra(), "two-row-sierra");
        apply(input, dithering.errorDiffusion().sierraLite(), "sierra-lite");
        apply(input, dithering.errorDiffusion().jarvisJudiceAndNinke(), "jarvis-judice-and-ninke");

        apply(input, dithering.ordered().bayer2x2(), "ordered-2x2");
        apply(input, dithering.ordered().bayer4x4(), "ordered-4x4");
        apply(input, dithering.ordered().bayer8x8(), "ordered-8x8");

        final OrderedThresholdTable table = OrderedThresholdTableLoader.fromFile("docs/ordered-custom-one.txt");
        apply(input, dithering.ordered().custom(table), "ordered-custom");

        final ErrorDiffusionTable custom = ErrorDiffusionTableLoader.fromFile("docs/error-diffusion-custom-one.txt");
        apply(input, dithering.errorDiffusion().custom(custom), "error-custom");

        apply(input, dithering.smartRandom(), "smart-random");
    }


    private static void apply(final GrayU8 input, final Dithering dithering, final String name) {
        final GrayU8 output = dithering.apply(input);
        UtilImageIO.saveImage(output, output(name));
    }

    private static String output(final String name) {
        return EXAMPLE.replace("lena", name);
    }

}
