package boofcv.alg.dithering;

import boofcv.struct.image.GrayU8;

public class OrderedDithering implements Dithering {

    private final OrderedThresholdTable table;
    private GrayU8 input;

    public OrderedDithering(OrderedThresholdTable table) {
        this.table = table;
    }

    @Override
    public void initialize(GrayU8 input) {
        this.input = input;
    }

    @Override
    public int doPixel(int x, int y) {
        if (input.get(x, y) > table.getValue(x, y)) {
            return 255;
        } else {
            return 0;
        }
    }

}
