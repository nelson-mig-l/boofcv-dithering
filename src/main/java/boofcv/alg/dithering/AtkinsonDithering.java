package boofcv.alg.dithering;

public class AtkinsonDithering extends AbstractErrorDithering {

    /**
     *         X   1   1
     *     1   1   1
     *         1
     *
     *       (1/8)
     */
    public AtkinsonDithering() {
        super(new ErrorDiffusionTable(4, 3, 1, 0));
        table.setValue(1, 0, 1);
        table.setValue(2, 0, 1);
        table.setValue(-1, 1, 1);
        table.setValue(0, 1 ,1);
        table.setValue(1, 1, 1);
        table.setValue(0, 2, 1);

        table.normalize(8);
    }

}
