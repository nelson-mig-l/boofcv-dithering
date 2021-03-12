package boofcv.alg.dithering;

public class TwoRowSierraDithering extends AbstractErrorDithering {

    /**
     *             X   4   3
     *     1   2   3   2   1
     *           (1/16)
     */
    public TwoRowSierraDithering() {
        super(new ErrorDiffusionTable(5, 2));
        table.setValue(1, 0, 4);
        table.setValue(2, 0, 3);
        table.setValue(-2, 1, 1);
        table.setValue(-1, 1, 2);
        table.setValue(0, 1, 3);
        table.setValue(1, 1, 2);
        table.setValue(2, 1, 1);
        table.normalize();
    }

}
