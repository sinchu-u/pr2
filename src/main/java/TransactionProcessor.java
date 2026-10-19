import java.util.ArrayList;
import java.util.List;

public abstract class TransactionProcessor {
    public static List<Transaction> processTransactions(List<String> lines) {
        List<Transaction> transactions = new ArrayList<>();
        for (String line : lines) {
            String[] values = line.split(",");

            if (values.length != 3) {
                throw new IllegalArgumentException("Invalid transaction data: " + line);
            }
            Transaction transaction = new Transaction(values[0].trim(), Double.parseDouble(values[1].trim()), values[2].trim());
            transactions.add(transaction);
        }
        return transactions;
    }
}