package boofcv.alg.dithering;

public class ErrorDiffusionDitheringFactory {

    public Dithering atkinson() {
        final ErrorDiffusionTable table = new ErrorDiffusionTable(4, 3, 1, 0);
        table.setValue(1, 0, 1);
        table.setValue(2, 0, 1);
        table.setValue(-1, 1, 1);
        table.setValue(0, 1 ,1);
        table.setValue(1, 1, 1);
        table.setValue(0, 2, 1);
        table.normalize(8);
        return new ErrorDiffusionDithering(table);
    }

    public Dithering burkes() {
        final ErrorDiffusionTable table = new ErrorDiffusionTable(5, 2);
        table.setValue(1, 0, 8);
        table.setValue(2, 0, 4);
        table.setValue(-2, 1, 2);
        table.setValue(-1, 1, 4);
        table.setValue(0, 1, 8);
        table.setValue(1, 1, 4);
        table.setValue(2, 1, 2);
        table.normalize();
        return new ErrorDiffusionDithering(table);
    }

    public Dithering floydSteinberg() {
        final ErrorDiffusionTable table = new ErrorDiffusionTable(3, 2);
        table.setValue(1, 0, 7);
        table.setValue(-1, 1, 3);
        table.setValue(0, 1, 5);
        table.setValue(1, 1, 1);
        table.normalize();
        return new ErrorDiffusionDithering(table);
    }

    public Dithering jarvisJudiceAndNinke() {
        final ErrorDiffusionTable table = new ErrorDiffusionTable(5, 3);
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
        return new ErrorDiffusionDithering(table);
    }

    public Dithering sierra() {
        final ErrorDiffusionTable table = new ErrorDiffusionTable(5, 3);
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
        return new ErrorDiffusionDithering(table);
    }

    public Dithering sierraLite() {
        final ErrorDiffusionTable table = new ErrorDiffusionTable(3, 2);
        table.setValue(1, 0, 2);
        table.setValue(-1, 1, 1);
        table.setValue(0, 1, 1);
        table.normalize();
        return new ErrorDiffusionDithering(table);
    }

    public Dithering stucki() {
        final ErrorDiffusionTable table = new ErrorDiffusionTable(5, 3);
        table.setValue(1, 0, 8);
        table.setValue(2, 0, 4);
        table.setValue(-2, 1, 2);
        table.setValue(-1, 1, 4);
        table.setValue(0, 1, 8);
        table.setValue(1, 1, 4);
        table.setValue(2, 1, 2);
        table.setValue(-2, 2, 1);
        table.setValue(-1, 2, 2);
        table.setValue(0, 2, 4);
        table.setValue(1, 2, 2);
        table.setValue(2, 2, 1);
        table.normalize();
        return new ErrorDiffusionDithering(table);
    }

    public Dithering twoRowSierra() {
        final ErrorDiffusionTable table = new ErrorDiffusionTable(5, 2);
        table.setValue(1, 0, 4);
        table.setValue(2, 0, 3);
        table.setValue(-2, 1, 1);
        table.setValue(-1, 1, 2);
        table.setValue(0, 1, 3);
        table.setValue(1, 1, 2);
        table.setValue(2, 1, 1);
        table.normalize();
        return new ErrorDiffusionDithering(table);
    }

}
