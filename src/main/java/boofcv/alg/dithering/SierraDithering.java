package boofcv.alg.dithering;

public class SierraDithering extends AbstractErrorDithering {

    /**
     *             X   5   3
     *      2   4  5   4   2
     *          2  3   2
     *           (1/32)
     */
    public SierraDithering() {
        super(new ErrorDiffusionTable(5, 3));
        table.setValue(1, 0, 5);
        table.setValue(2, 0, 3);

        table.setValue(-2, 1, 2);
        table.setValue(-1, 1, 4);
        table.setValue(0, 1, 5);
        table.setValue(1, 1, 4);
        table.setValue(2, 1, 2);

        table.setValue(-1, 2, 2);
        table.setValue(0, 2, 3);
        table.setValue(1, 2, 2);

        table.normalize();
    }

}
