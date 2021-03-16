package boofcv;

import boofcv.alg.dithering.Dithering;
import boofcv.alg.dithering.DitheringFactory;
import boofcv.alg.dithering.DitheringOperation;
import boofcv.io.image.ConvertBufferedImage;
import boofcv.io.image.UtilImageIO;
import boofcv.struct.image.GrayU8;
import boofcv.struct.image.ImageType;
import boofcv.struct.image.Planar;

import java.awt.image.BufferedImage;

public class App {

    private static final String NAME = "lena";
    private static final String EXAMPLE = "docs/" + NAME + ".bmp";

    public static void main(String[] args) {
        final BufferedImage image = UtilImageIO.loadImage(EXAMPLE);
        final GrayU8 input = new GrayU8(image.getWidth(), image.getHeight());
        ConvertBufferedImage.convertFromSingle(image, input, GrayU8.class);
        UtilImageIO.saveImage(input, output("bw-ref"));

        final Planar<GrayU8> color = ConvertBufferedImage.convertFrom(image, true, ImageType.pl(3, GrayU8.class));

        final DitheringFactory dithering = new DitheringFactory();

        apply(input, dithering.average(), "average");
        //apply(color, dithering.average(), "average-color");

        apply(input, dithering.random(), "random");
        //apply(color, dithering.random(), "random-color");

        apply(input, dithering.simple(), "simple");
        //apply(color, dithering.simple(), "simple-color");

        apply(input, dithering.smartRandom(), "smart-random");
        //apply(color, dithering.smartRandom(), "smart-random-color");

        apply(input, dithering.errorDiffusion().atkinson(), "atkinson");
        //apply(color, dithering.errorDiffusion().atkinson(), "atkinson-color");

        apply(input, dithering.errorDiffusion().burkes(), "burkes");
        //apply(color, dithering.errorDiffusion().burkes(), "burkes-color");

        apply(input, dithering.errorDiffusion().floydSteinberg(), "floyd-steinberg");
        //apply(color, dithering.errorDiffusion().floydSteinberg(), "floyd-steinberg-color");

        apply(input, dithering.errorDiffusion().jarvisJudiceAndNinke(), "jarvis-judice-and-ninke");
        //apply(color, dithering.errorDiffusion().jarvisJudiceAndNinke(), "jarvis-judice-and-ninke-color");

        apply(input, dithering.errorDiffusion().sierra(), "sierra");
        //apply(color, dithering.errorDiffusion().sierra(), "sierra-color");

        apply(input, dithering.errorDiffusion().sierraLite(), "sierra-lite");
        //apply(color, dithering.errorDiffusion().sierraLite(), "sierra-lite-color");

        apply(input, dithering.errorDiffusion().stucki(), "stucki");
        //apply(color, dithering.errorDiffusion().stucki(), "stucki-color");

        apply(input, dithering.errorDiffusion().twoRowSierra(), "two-row-sierra");
        //apply(color, dithering.errorDiffusion().twoRowSierra(), "two-row-sierra-color");

        apply(input, dithering.ordered().bayer2x2(), "bayer-2x2");
        //apply(color, dithering.ordered().bayer2x2(), "bayer-2-color");

        apply(input, dithering.ordered().bayer4x4(), "bayer-4x4");
        //apply(color, dithering.ordered().bayer4x4(), "bayer-4-color");

        apply(input, dithering.ordered().bayer8x8(), "bayer-8x8");
        //apply(color, dithering.ordered().bayer8x8(), "bayer-8-color");

        apply(input, dithering.ordered().cluster4x4(), "cluster-4x4");
        //apply(color, dithering.ordered().cluster4x4(), "cluster-4-color");

        apply(input, dithering.ordered().cluster8x8(), "cluster-8x8");
        //apply(color, dithering.ordered().cluster8x8(), "cluster-8-color");
    }

    private static void apply(final Planar<GrayU8> input, final Dithering dithering, final String name) {
        final DitheringOperation operation = new DitheringOperation(dithering);
        final Planar<GrayU8> output = operation.apply(input);
        UtilImageIO.saveImage(output, output(name));
    }

    private static void apply(final GrayU8 input, final Dithering dithering, final String name) {
        final DitheringOperation operation = new DitheringOperation(dithering);
        final GrayU8 output = operation.apply(input);
        UtilImageIO.saveImage(output, output(name));
    }

    private static String output(final String name) {
        return EXAMPLE.replace(NAME, name);
    }
}
