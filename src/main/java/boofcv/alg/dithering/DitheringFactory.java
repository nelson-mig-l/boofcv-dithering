package boofcv.alg.dithering;

public class DitheringFactory {

    public Dithering average() {
        return new AverageDithering();
    }

    public Dithering random() {
        return new RandomDithering();
    }

    public Dithering simple() {
        return new SimpleDithering();
    }

    public Dithering smartRandom() {
        return new SmartRandomDithering();
    }

    public ErrorDiffusionDitheringFactory errorDiffusion() {
        return new ErrorDiffusionDitheringFactory();
    }

    public OrderedDitheringFactory ordered() {
        return new OrderedDitheringFactory();
    }

}
