package boofcv.alg.dithering;

public class SierraLiteDithering extends AbstractErrorDithering {

    /**
     *             X   2
     *         1   1
     *           (1/4)
     */
    public SierraLiteDithering() {
        super(new ErrorDiffusionTable(3, 2));
        table.setValue(1, 0, 2);
        table.setValue(-1, 1, 1);
        table.setValue(0, 1, 1);
        table.normalize();
    }

}
