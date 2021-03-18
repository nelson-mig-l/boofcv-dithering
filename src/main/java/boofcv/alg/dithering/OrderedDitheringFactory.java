package boofcv.alg.dithering;

import java.util.Arrays;

public class OrderedDitheringFactory {

    public Dithering bayer2x2() {
        final OrderedThresholdTable table = bayerInternal(1);
        table.scale();
        return new OrderedDithering(table);
    }

    public Dithering bayer4x4() {
        final OrderedThresholdTable table = bayerInternal(2);
        table.scale();
        return new OrderedDithering(table);
    }

    public Dithering bayer8x8() {
        final OrderedThresholdTable table = bayerInternal(3);
        table.scale();
        return new OrderedDithering(table);
    }

    public Dithering bayer(int rank) {
        final OrderedThresholdTable table = bayerInternal(rank);
        table.scale();
        return new OrderedDithering(table);
    }

    public Dithering cluster4x4() {
        int[] data = {
                12, 5, 6, 13,
                4, 0, 1, 7,
                11, 3, 2, 8,
                15, 10, 9, 14
        };
        final OrderedThresholdTable table = new OrderedThresholdTable(4, data);
        table.scale();
        return new OrderedDithering(table);
    }

    public Dithering cluster8x8() {
        int[] data = {
                24, 10, 12, 26, 35, 47, 49, 37,
                8, 0, 2, 14, 45, 59, 61, 51,
                22, 6, 4, 16, 43, 57, 63, 53,
                30, 20, 18, 28, 33, 41, 55, 39,
                34, 46, 48, 36, 25, 11, 13, 27,
                44, 57, 60, 50, 9, 1, 3, 15,
                42, 56, 62, 52, 23, 7, 5, 17,
                32, 40, 54, 38, 31, 21, 19, 29
        };
        final OrderedThresholdTable table = new OrderedThresholdTable(8, data);
        table.scale();
        return new OrderedDithering(table);
    }

    /**
     * Will create a bayer matrix of size 2^rank * 2^rank.
     * Advised to maintain rank bellow 10. (Why would you need matrix of size 1024*1024 ?)
     * @param rank
     * @return
     */
    OrderedThresholdTable bayerInternal(int rank) {
        int[][] mat = bayer(rank, new int[1][1]);
        int[] data = Arrays.stream(mat)
                .flatMapToInt(Arrays::stream)
                .toArray();
        return new OrderedThresholdTable(mat.length, data);
    }

    // This shity stuff from libcaca
    private int[][] bayer(int rank, int[][] mat) {
        if (rank == 0) return mat;
        int n = mat.length;
        int[][] data = new int[n * 2][n * 2];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                int x = mat[i][j];
                data[i * 2][j * 2] = x;
                data[i * 2 + 1][j * 2] = x + n * n * 3;
                data[i * 2][j * 2 + 1] = x + n * n * 2;
                data[i * 2 + 1][j * 2 + 1] = x + n * n;
            }
        }
        return bayer(rank - 1, data);
    }

    // Cluster 6x6
    // https://archive.is/71e9G



//    public Dithering cluster5x3() {
//        int[] data = {
//                9, 3, 0, 6, 12,
//                10, 4, 1, 7, 13,
//                11, 5, 2, 8, 14
//        };
//        final OrderedThresholdTable table = new OrderedThresholdTable(8, data);
//        table.scale();
//        return new OrderedDithering(table);
//    }

    public Dithering custom(OrderedThresholdTable table) {
        return new OrderedDithering(table);
    }

}
