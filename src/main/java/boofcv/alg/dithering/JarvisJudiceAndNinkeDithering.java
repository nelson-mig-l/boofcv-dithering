package boofcv.alg.dithering;

public class JarvisJudiceAndNinkeDithering extends AbstractErrorDithering {

    /**
     *              X   7   5
     *      3   5   7   5   3
     *      1   3   5   3   1
     */
    public JarvisJudiceAndNinkeDithering() {
        super(new ErrorDiffusionTable(5, 3));
        table.setValue(1, 0, 7);
        table.setValue(2, 0, 5);

        table.setValue(-2, 1, 3);
        table.setValue(-1, 1, 5);
        table.setValue(0, 1, 7);
        table.setValue(1, 1, 5);
        table.setValue(2, 1, 3);

        table.setValue(-2, 2, 1);
        table.setValue(-1, 2, 3);
        table.setValue(0, 2, 5);
        table.setValue(1, 2, 3);
        table.setValue(2, 2, 1);

        table.normalize();
    }

}
