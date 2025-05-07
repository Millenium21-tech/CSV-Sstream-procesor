import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;
import java.nio.file.Paths;

public class CSVStreamProcessor {
    public static double calculateAverageAge(String csvFilePath) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(csvFilePath))) {
            return lines
                    .skip(1)
                    .map(line -> line.split(","))
                    .filter(parts -> parts.length == 2)
                    .map(parts -> parts[1].trim())
                    .peek(age -> System.out.println("Age :" + age))
                    .mapToInt(age -> {
                        try {
                            return Integer.parseInt(age);

                        } catch (NumberFormatException e) {
                            return -1;
                        }

                    })
                    .filter(age -> age >= 0)
                    .average()
                    .orElse(0.0);


        }
    }
}