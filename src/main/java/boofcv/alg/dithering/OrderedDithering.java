package boofcv.alg.dithering;

public class OrderedDithering extends AbstractDithering {

    private final OrderedThresholdTable table;

    public OrderedDithering(OrderedThresholdTable table) {
        this.table = table;
    }

    @Override
    protected void doPixel(int x, int y) {
        if (input.get(x, y) > table.getValue(x, y)) {
            output.set(x, y, 255);
        } else {
            output.set(x, y, 0);
        }
    }

}
