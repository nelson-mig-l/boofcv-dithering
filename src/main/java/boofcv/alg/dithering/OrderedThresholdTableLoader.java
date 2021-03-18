package boofcv.alg.dithering;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class OrderedThresholdTableLoader {

    public static OrderedThresholdTable fromFile(String name) {
        try {
            final int[] data = Files.readAllLines(Path.of(name)).stream()
                    .filter(line -> !line.startsWith("#"))
                    .map(line -> line.split(","))
                    .map(Arrays::asList)
                    .flatMap(List::stream)
                    .map(String::trim)
                    .map(Integer::valueOf)
                    .mapToInt(i -> i)
                    .toArray();
            final int size = (int) Math.sqrt(data.length);
            final OrderedThresholdTable table = new OrderedThresholdTable(size, data);
            table.scale();
            return table;
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

}
