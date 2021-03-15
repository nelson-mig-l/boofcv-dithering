//package boofcv.alg.dithering;
//
//import boofcv.struct.image.GrayU8;
//
//public class SimpleSerpentineDithering extends AbstractDithering {
//
//    public GrayU8 apply(GrayU8 input) {
//        GrayU8 output = input.createSameShape();
//        for (int y = 0; y < input.height; y++) {
//            int error = 0;
//            if (y % 2 == 0) {
//                for (int x = 0; x < input.width; x++) {
//                    final int source = input.get(x, y) + error;
//                    int blackError = source;
//                    int whiteError = blackError - 255;
//                    if (Math.abs(whiteError) < Math.abs(blackError)) {
//                        error = whiteError;
//                        output.set(x, y, 255);
//                    } else {
//                        error = blackError;
//                        output.set(x, y, 0);
//                    }
//                }
//            } else {
//                for (int x = input.width - 1; x >= 0; x--) {
//                    final int source = input.get(x, y) + error;
//                    int blackError = source;
//                    int whiteError = blackError - 255;
//                    if (Math.abs(whiteError) < Math.abs(blackError)) {
//                        error = whiteError;
//                        output.set(x, y, 255);
//                    } else {
//                        error = blackError;
//                        output.set(x, y, 0);
//                    }
//                }
//            }
//        }
//        return output;
//    }
//
//    @Override
//    public void doPixel(int x, int y) {
//        throw new RuntimeException("Work in progress");
//    }
//}
