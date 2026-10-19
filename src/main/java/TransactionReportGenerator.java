import java.util.List;
import java.util.Map;

public abstract class TransactionReportGenerator {
    public static void printBalanceReport(double totalBalance) {
        System.out.println("Загальний баланс: " + totalBalance);
    }

    public static void printTransactionsCountByMonth(String monthYear, int count) {
        System.out.println("Кількість транзакцій за " + monthYear + ": " + count);
    }

    public static void printTopExpensesReport(List<Transaction> topExpenses) {
        System.out.println("10 найбільших витрат:");
        for (Transaction expense : topExpenses) {
            System.out.println(expense.getDescription() + ": " + expense.getAmount());
        }
    }

    public static void printTopAndLowReport(String monthYear, List<Transaction> topAndLow) {
        System.out.println("Найбільша транзакція за " + monthYear + ": " + topAndLow.getFirst().getAmount());
        System.out.println("Найменша транзакція за " + monthYear + ": " + topAndLow.getLast().getAmount());
    }

    public static void printExpensesByMonthsReport(Map<String, Double> expenses) {
        System.out.println("Витрати за місяці:");
        for (Map.Entry<String, Double> entry : expenses.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void printExpensesByCategoryReport(Map<String, Double> expenses) {
        System.out.println("Витрати по категоріям");
        for (Map.Entry<String, Double> entry : expenses.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
