import org.junit.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TransactionCSVReaderTest {
    @TempDir
    Path tempDir;

    @Test
    public void shouldReadTransactionsFromCSV() throws IOException {
        Path csvFile = tempDir.resolve("transactions.csv");
        List<String> expectedLines = List.of("01-02-2023,50.0,Дохід", "15-02-2023,-20.0,Витрата", "05-03-2023,-100.0,Витрата");

        Files.write(csvFile, expectedLines);
        List<String> actualLines = TransactionCSVReader.readTransactions(csvFile.toString());

        assertEquals(expectedLines, actualLines);
        assertEquals(3, actualLines.size());
    }
}