package boofcv.alg.dithering;

public class ErrorDiffusionTable {

    private final double[][] table;
    private final int offsetX;
    private final int offsetY;

    ErrorDiffusionTable(int width, int height) {
        this(width, height, width / 2, 0);
    }

    ErrorDiffusionTable(int width, int height, int offsetX, int offsetY) {
        this.table = new double[width][height];
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }

    void normalize() {
        double sum = 0;
        for (int i = 0; i < table.length; i++) {
            final double[] arr = table[i];
            for (int j = 0; j < arr.length; j++) {
                sum += arr[j];
            }
        }

        normalize(sum);
    }

    void normalize(double sum) {
        for (int i = 0; i < table.length; i++) {
            final double[] arr = table[i];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = arr[j] / sum;
            }
        }
    }

    void setValue(int x, int y, double value) {
        table[x + offsetX][y + offsetY] = value;
    }

    double getValue(int x, int y) {
        return table[x + offsetX][y + offsetY];
    }

    int minX() {
        return -offsetX;
    }

    int maxX() {
        return table.length - offsetX - 1;
    }

    int minY() {
        return 0;
    }

    int maxY() {
        return table[0].length-1;
    }

}
