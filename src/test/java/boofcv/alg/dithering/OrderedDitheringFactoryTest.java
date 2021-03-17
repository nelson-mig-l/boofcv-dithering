package boofcv.alg.dithering;

import org.junit.Test;

public class OrderedDitheringFactoryTest {

    @Test
    public void t() {
        final OrderedDitheringFactory f = new OrderedDitheringFactory();
        final int[][] generated = f.bayer(4);
        int[] data = {
                0, 8, 2, 10,
                12, 4, 14, 6,
                3, 11, 1, 9,
                15, 7, 13, 5
        };
        final OrderedThresholdTable declared = new OrderedThresholdTable(4, data);
        declared.scale();

        System.out.println("=================");

        for (int j =0;j < 4; j++) {
            for (int i =0; i< 4; i++) {
                if (declared.getValue(i, j) != generated[j][i]) { // reversed indexes in generated
                    throw new RuntimeException(declared.getValue(i, j) + "!=" + generated[i][j]);
                } else {
                    System.out.print(declared.getValue(j, i) + "\t"); // reversed indexes in declared
                }
            }
            System.out.println();
        }


    }


}
