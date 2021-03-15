package boofcv.alg.dithering;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class ErrorDiffusionTableLoader {

    public static ErrorDiffusionTable fromFile(String name) {
        try {
            final ErrorDiffusionTable table = new ErrorDiffusionTable(2, 2, 0, 0);
            int x = 0;
            int y = 0;
            List<String> lines = Files.readAllLines(Path.of(name)).stream()
                    .filter(l -> !l.startsWith("#"))
                    .collect(Collectors.toList());
            final String size = lines.remove(0);
            final String offset = lines.remove(0);
            for (String line : lines) {
                if (line.startsWith("#")) continue;
                String[] tokens = line.split(",");
                for (String token : tokens) {
                    int value = Integer.parseInt(token.trim());
                    table.setValue(x, y, value);
                    x++;
                }
                x = 0;
                y++;
            }
            table.normalize();
            return table;
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

}
