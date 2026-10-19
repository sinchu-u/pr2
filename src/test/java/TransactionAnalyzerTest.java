import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class TransactionAnalyzerTest {
    @Test
    public void testCalculateTotalBalance() {
        // Створення тестових даних
        Transaction transaction1 = new Transaction("2023-01-01", 100.0, "Дохід");
        Transaction transaction2 = new Transaction("2023-01-02", -50.0, "Витрата");
        Transaction transaction3 = new Transaction("2023-01-03", 150.0, "Дохід");
        List<Transaction> transactions = Arrays.asList(transaction1, transaction2, transaction3);

        // Виклик методу, який потрібно протестувати
        double result = TransactionAnalyzer.calculateTotalBalance(transactions);

        // Перевірка результату
        Assertions.assertEquals(200.0, result, "Розрахунок загального балансу неправильний");
    }

    @Test
    public void testCountTransactionsByMonth() {
        // Підготовка тестових даних
        Transaction transaction1 = new Transaction("01-02-2023", 50.0, "Дохід");
        Transaction transaction2 = new Transaction("15-02-2023", -20.0, "Витрата");
        Transaction transaction3 = new Transaction("05-03-2023", 100.0, "Дохід");
        List<Transaction> transactions = Arrays.asList(transaction1, transaction2, transaction3);

        int countFeb = TransactionAnalyzer.countTransactionsByMonth("02-2023", transactions);
        int countMar = TransactionAnalyzer.countTransactionsByMonth("03-2023", transactions);

        // Перевірка результатів
        Assertions.assertEquals(2, countFeb, "Кількість транзакцій за лютий неправильна");
        Assertions.assertEquals(1, countMar, "Кількість транзакцій за березень неправильна");
    }

    @Test
    public void findTopExpenses(){
        Transaction transaction1 = new Transaction("01-02-2023", 50.0, "Дохід");
        Transaction transaction2 = new Transaction("15-02-2023", -20.0, "Витрата");
        Transaction transaction3 = new Transaction("05-03-2023", -100.0, "Витрата");
        Transaction transaction4 = new Transaction("01-02-2023", -130.0, "Витрата");
        Transaction transaction5 = new Transaction("15-02-2023", -80.0, "Витрата");
        Transaction transaction6 = new Transaction("05-03-2023", 100.0, "Дохід");
        Transaction transaction7 = new Transaction("05-03-2023", -150.0, "Витрата");
        Transaction transaction8 = new Transaction("01-02-2023", -160.0, "Витрата");
        Transaction transaction9 = new Transaction("15-02-2023", -85.0, "Витрата");
        Transaction transaction10 = new Transaction("05-03-2023", 100.0, "Дохід");
        Transaction transaction11 = new Transaction("05-03-2023", -250.0, "Витрата");
        Transaction transaction12 = new Transaction("01-02-2023", -260.0, "Витрата");
        Transaction transaction13 = new Transaction("15-02-2023", -25.0, "Витрата");

        List<Transaction> transactions = Arrays.asList(transaction1, transaction2, transaction3, transaction4, transaction5,
                transaction6, transaction7, transaction8, transaction9, transaction10, transaction11, transaction12, transaction13);

        List<Transaction> topExpenses = TransactionAnalyzer.findTopExpenses(transactions);
        Assertions.assertEquals(10, topExpenses.size(), "Кількість топ транзакцій неправильна");
    }
}