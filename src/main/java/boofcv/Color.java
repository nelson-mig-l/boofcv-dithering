package boofcv;

import boofcv.alg.dithering.*;
import boofcv.io.image.ConvertBufferedImage;
import boofcv.io.image.UtilImageIO;
import boofcv.struct.image.GrayU8;
import boofcv.struct.image.ImageType;
import boofcv.struct.image.Planar;

import java.awt.image.BufferedImage;

public class Color {
    private static final String EXAMPLE = "docs/nelson.png";

    public static void main(String[] args) {
        final BufferedImage image = UtilImageIO.loadImage(EXAMPLE);
        final Planar<GrayU8> rgb = ConvertBufferedImage.convertFrom(image, true, ImageType.pl(3, GrayU8.class));

        final DitheringFactory dithering = new DitheringFactory();
        final GrayU8 r = rgb.getBand(0);
        final GrayU8 g = rgb.getBand(1);
        final GrayU8 b = rgb.getBand(2);
        //final OrderedThresholdTable table = OrderedThresholdTableLoader.fromFile("docs/ordered-custom-one.txt");
        //final Dithering dither = dithering.ordered().custom(table);
        //final Dithering dither = dithering.ordered().bayer4x4();
        final ErrorDiffusionTable table = ErrorDiffusionTableLoader.fromFile("docs/error-diffusion-custom-one.txt");
        final Dithering dither = dithering.errorDiffusion().custom(table);
        final GrayU8 dr = dither.apply(r);
        final GrayU8 dg = dither.apply(g);
        final GrayU8 db = dither.apply(b);
        final Planar<GrayU8> out = rgb.createSameShape();
        GrayU8[] bands = {dr, dg, db};
        out.setBands(bands);
        UtilImageIO.saveImage(out, "docs/color.png");
    }


}
