import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.List;

public abstract class TransactionCSVReader {
    public static List<String> readTransactions(String filePath) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(
                new FileReader(filePath))) {

            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }

        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return lines;
    }
}
