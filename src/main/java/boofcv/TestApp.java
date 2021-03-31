package boofcv;

import boofcv.alg.dithering.*;
import boofcv.io.image.ConvertBufferedImage;
import boofcv.io.image.UtilImageIO;
import boofcv.struct.image.GrayU8;
import boofcv.struct.image.ImageType;
import boofcv.struct.image.Planar;

import java.awt.image.BufferedImage;

public class TestApp {

    private static final String NAME = "lena";
    private static final String EXAMPLE = "docs/" + NAME + ".png";

    private final GrayU8 gray;
    private final Planar<GrayU8> color;
    private boolean generateColor = true;

    public static void main(String[] args) {
        new TestApp().run();
    }

    public TestApp() {
        BufferedImage image = UtilImageIO.loadImage(EXAMPLE);
        gray = new GrayU8(image.getWidth(), image.getHeight());
        ConvertBufferedImage.convertFromSingle(image, gray, GrayU8.class);
        color = ConvertBufferedImage
                .convertFrom(image, true, ImageType.pl(3, GrayU8.class));
        UtilImageIO.saveImage(gray, output("gray"));
        UtilImageIO.saveImage(color, output("color"));
    }

    public void run() {
        final DitheringFactory dithering = new DitheringFactory();

        apply(dithering.average(), "average");

        apply(dithering.random(), "random");

        apply(dithering.smartRandom(), "smart-random"); //

        apply(dithering.gaussianRandom(), "gaussian-random");

        apply(dithering.simple(), "simple");

        apply(dithering.errorDiffusion().floydSteinberg(), "floyd-steinberg");

        apply(dithering.errorDiffusion().jarvisJudiceAndNinke(), "jarvis-judice-and-ninke");

        apply(dithering.errorDiffusion().stucki(), "stucki");

        apply(dithering.errorDiffusion().atkinson(), "atkinson");

        apply(dithering.errorDiffusion().burkes(), "burkes");

        apply(dithering.errorDiffusion().sierra(), "sierra");

        apply(dithering.errorDiffusion().twoRowSierra(), "two-row-sierra");

        apply(dithering.errorDiffusion().sierraLite(), "sierra-lite");

        apply(dithering.ordered().bayer2x2(), "bayer-2x2");

        apply(dithering.ordered().bayer4x4(), "bayer-4x4");

        apply(dithering.ordered().bayer8x8(), "bayer-8x8");

        apply(dithering.ordered().bayer(4), "bayer-rank-4-16x16"); //

        apply(dithering.ordered().cluster4x4(), "cluster-4x4");

        apply(dithering.ordered().cluster8x8(), "cluster-8x8");

        final OrderedThresholdTable customCluster4x4 = OrderedThresholdTableLoader
                .fromFile("src/main/resources/ordered-cluster-alternative-4x4.txt");
        apply(dithering.ordered().custom(customCluster4x4), "custom-cluster-4x4"); //

        final OrderedThresholdTable customCluster8x8 = OrderedThresholdTableLoader
                .fromFile("src/main/resources/ordered-cluster-impa-br-8x8.txt");
        apply(dithering.ordered().custom(customCluster8x8), "custom-cluster-8x8"); //

    }

    private void apply(final Dithering dithering, final String name) {
        final DitheringOperation operation = new DitheringOperation(dithering);
        final GrayU8 output = operation.apply(gray);
        UtilImageIO.saveImage(output, output(name));
        if (generateColor) {
            final Planar<GrayU8> outputColor = operation.apply(color);
            UtilImageIO.saveImage(outputColor, output(name + "-color"));
        }
    }

    private String output(final String name) {
        return EXAMPLE.replace(NAME, name);
    }
}
