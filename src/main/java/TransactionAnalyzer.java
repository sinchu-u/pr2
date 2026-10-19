import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public abstract class TransactionAnalyzer {
    private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    // Метод для розрахунку загального балансу
    public static double calculateTotalBalance(List<Transaction> transactions) {
        double balance = 0;
        for (Transaction transaction : transactions) {
            balance += transaction.getAmount();
        }
        return balance;
    }

    public static int countTransactionsByMonth(String monthYear, List<Transaction> transactions) {
        int count = 0;
        for (Transaction transaction : transactions) {
            LocalDate date = LocalDate.parse(transaction.getDate(), dateFormatter);
            String transactionMonthYear = date.format(DateTimeFormatter.ofPattern("MM-yyyy"));
            if (transactionMonthYear.equals(monthYear)) {
                count++;
            }
        }
        return count;
    }

    public static List<Transaction> findTopExpenses(List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0) // Вибірка лише витрат (від'ємні значення)
                .sorted(Comparator.comparing(Transaction::getAmount)) // Сортування за сумою
                .limit(10) // Обмеження результату першими 10 записами
                .collect(Collectors.toList()); // Збір результату в список
    }

    public static List<Transaction> findTopAndLowExpenses(String monthYear, List<Transaction> transactions) {
        List<Transaction> allTransactions = transactions.stream().filter(t -> LocalDate.parse(t.getDate(), dateFormatter)
                .format(DateTimeFormatter.ofPattern("MM-yyyy")).equals(monthYear))
                .sorted(Comparator.comparing(Transaction::getAmount))
                .filter(t -> t.getAmount() < 0)
                .toList();
        List<Transaction> topAndLow = new ArrayList<>();
        topAndLow.add(allTransactions.getFirst());
        topAndLow.add(allTransactions.getLast());
        return topAndLow;
    }

    public static Map<String, Double> findExpensesByMonths(List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .collect(Collectors.groupingBy(t -> LocalDate.parse(t.getDate(), dateFormatter)
                                .format(DateTimeFormatter.ofPattern("MM-yyyy")), Collectors.summingDouble(Transaction::getAmount)));
    }

    public static Map<String, Double> findExpensesByCategory(List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .collect(Collectors.groupingBy(Transaction::getDescription, Collectors.summingDouble(Transaction::getAmount)));
    }
}
