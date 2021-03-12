package boofcv.alg.dithering;

public class SimpleDithering extends AbstractDithering {

    private int error = 0;
    private int lastY = 0;

    @Override
    public void doPixel(int x, int y) {
        if (lastY != y) {lastY = y; error = 0;} // little dirty hack
        int blackError = input.get(x, y) + error;
        int whiteError = blackError - 255;
        if (Math.abs(whiteError) > Math.abs(blackError)) {
            error = blackError;
            output.set(x, y, 0);
        } else {
            error = whiteError;
            output.set(x, y, 255);
        }
    }
}
