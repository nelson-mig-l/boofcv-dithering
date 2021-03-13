package boofcv.alg.dithering;

public class OrderedThresholdTable {

    private final int size;
    private final int[] data;

    public OrderedThresholdTable(int size, int[] data) {
        this.size = size;
        this.data = data;
    }

    public int getValue(int x, int y) {
        return data[y % size + size * (x % size)];
    }

    public void scale() {
        int multiplier = 256 / data.length;
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i] * multiplier;
        }
    }
}
