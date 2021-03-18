package boofcv.alg.dithering;

import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class OrderedDitheringFactoryTest {

    @Test
    public void t2() {
        final OrderedDitheringFactory f = new OrderedDitheringFactory();
        final OrderedThresholdTable actual = f.bayerInternal(1);
        actual.scale();

        int[] data = {
                0, 2,
                3, 1
        };
        final OrderedThresholdTable expected = new OrderedThresholdTable(2, data);
        expected.scale();

        print(actual, 2, "actual");
        print(expected, 2, "expected");

        assertTableEquals(expected, actual, 2);
    }


    @Test
    public void t4() {
        final OrderedDitheringFactory f = new OrderedDitheringFactory();
        final OrderedThresholdTable actual = f.bayerInternal(2);
        actual.scale();

        int[] data = {
                0, 8, 2, 10,
                12, 4, 14, 6,
                3, 11, 1, 9,
                15, 7, 13, 5
        };
        final OrderedThresholdTable expected = new OrderedThresholdTable(4, data);
        expected.scale();

        print(actual, 4, "actual");
        print(expected, 4, "expected");

        assertTableEquals(expected, actual, 4);
    }

    @Test
    public void t8() {
        final OrderedDitheringFactory f = new OrderedDitheringFactory();
        final OrderedThresholdTable actual = f.bayerInternal(3);
        actual.scale();

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
        final OrderedThresholdTable expected = new OrderedThresholdTable(8, data);
        expected.scale();

        print(actual, 8, "actual");
        print(expected, 8, "expected");

        assertTableEquals(expected, actual, 8);
    }


    private void assertTableEquals(OrderedThresholdTable expected, OrderedThresholdTable actual, int size) {
        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size; i++) {
                final int a = actual.getValue(i, j);
                final int e = expected.getValue(i, j);
                assertEquals(e, a);
            }
        }
    }

    private void print(OrderedThresholdTable table, int size, String name) {
        System.out.println("=== " + name);
        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size; i++) {
                System.out.print(table.getValue(i, j) + "\t");
            }
            System.out.println();
        }
    }

    @Test
    @Ignore
    public void xxx() {
        final OrderedDitheringFactory f = new OrderedDitheringFactory();
        for (int rank = 1; rank < 64; rank++) {
            System.out.print("Generating " + rank + "...");
            f.bayer(rank);
            System.out.println();
        }
    }

}

