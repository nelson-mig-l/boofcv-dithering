package boofcv.alg.dithering;

public class DitheringTable {

    private final double[][] table;
    private final int offsetX;
    private final int offsetY;

    public DitheringTable(int width, int height) {
        this(width, height, width / 2, 0);
    }

    public DitheringTable(int width, int height, int offsetX, int offsetY) {
        this.table = new double[width][height];
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }

    public void normalize() {
        double sum = 0;
        for (int i = 0; i < table.length; i++) {
            final double[] arr = table[i];
            for (int j = 0; j < arr.length; j++) {
                sum += arr[j];
            }
        }

        normalize(sum);
    }

    public void normalize(double sum) {
        for (int i = 0; i < table.length; i++) {
            final double[] arr = table[i];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = arr[j] / sum;
            }
        }
    }

    public void setValue(int x, int y, double value) {
        table[x + offsetX][y + offsetY] = value;
    }

    public double getValue(int x, int y) {
        return table[x + offsetX][y + offsetY];
    }

}
