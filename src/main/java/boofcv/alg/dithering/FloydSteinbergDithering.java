package boofcv.alg.dithering;

public class FloydSteinbergDithering extends AbstractErrorDithering {

    public FloydSteinbergDithering() {
        super(new ErrorDiffusionTable(3, 2));
        table.setValue(1, 0, 7);
        table.setValue(-1, 1, 3);
        table.setValue(0, 1, 5);
        table.setValue(1, 1, 1);
        table.normalize();
    }

}
