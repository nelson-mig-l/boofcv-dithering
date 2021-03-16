package boofcv.alg.dithering;

public class OrderedDitheringFactory {

    public Dithering bayer2x2() {
        int[] data = {
                0, 2,
                3, 1
        };
        final OrderedThresholdTable table = new OrderedThresholdTable(2, data);
        table.scale();
        return new OrderedDithering(table);
    }

    public Dithering bayer4x4() {
        int[] data = {
                0, 8, 2, 10,
                12, 4, 14, 6,
                3, 11, 1, 9,
                15, 7, 13, 5
        };
        final OrderedThresholdTable table = new OrderedThresholdTable(4, data);
        table.scale();
        return new OrderedDithering(table);
    }

    public Dithering bayer8x8() {
        int[] data = {
                0, 32, 8, 40, 2, 34, 10, 42,
                48, 16, 56, 24, 50, 18, 58, 26,
                12, 44, 4, 36, 14, 46, 6, 38,
                60, 28, 52, 20, 62, 30, 54, 22,
                3, 35, 11, 43, 1, 33, 9, 41,
                51, 19, 59, 27, 49, 17, 57, 25,
                15, 47, 7, 39, 13, 45, 5, 37,
                63, 31, 55, 23, 61, 29, 53, 21
        };
        final OrderedThresholdTable table = new OrderedThresholdTable(8, data);
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
