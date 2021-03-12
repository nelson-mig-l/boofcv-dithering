package boofcv.alg.dithering;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ErrorDiffusionTableTest {

    @Test
    public void testTableBounds() {
        final ErrorDiffusionTable big = new ErrorDiffusionTable(5, 3);
        assertBoundsX(big, -2, 2);
        assertBoundsY(big, 0, 2);

        final ErrorDiffusionTable small = new ErrorDiffusionTable(3, 2);
        assertBoundsX(small, -1, 1);
        assertBoundsY(small, 0, 1);

        final ErrorDiffusionTable evenWidth = new ErrorDiffusionTable(4, 3, 1, 0);
        assertBoundsX(evenWidth, -1, 2);
        assertBoundsY(evenWidth, 0, 2);
    }

    private void assertBoundsX(ErrorDiffusionTable table, int expectedMinX, int expectedMaxX) {
        assertEquals(expectedMinX, table.minX());
        assertEquals(expectedMaxX, table.maxX());
    }

    private void assertBoundsY(ErrorDiffusionTable table, int expectedMinY, int expectedMaxY) {
        assertEquals(expectedMinY, table.minY());
        assertEquals(expectedMaxY, table.maxY());
    }

}
