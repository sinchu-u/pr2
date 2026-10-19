import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String filePath = "info.csv";
        List<String> lines = TransactionCSVReader.readTransactions(filePath);
        List<Transaction> transactions = TransactionProcessor.processTransactions(lines);

        double totalBalance = TransactionAnalyzer.calculateTotalBalance(transactions);
        TransactionReportGenerator.printBalanceReport(totalBalance);

        String monthYear = "01-2024";
        int transactionsCount = TransactionAnalyzer.countTransactionsByMonth(monthYear, transactions);
        TransactionReportGenerator.printTransactionsCountByMonth(monthYear, transactionsCount);

        monthYear = "12-2023";
        List<Transaction> topAndLow = TransactionAnalyzer.findTopAndLowExpenses(monthYear, transactions);
        TransactionReportGenerator.printTopAndLowReport(monthYear, topAndLow);

        List<Transaction> topExpenses = TransactionAnalyzer.findTopExpenses(transactions);
        TransactionReportGenerator.printTopExpensesReport(topExpenses);

        Map<String, Double> expensesByMonth = TransactionAnalyzer.findExpensesByMonths(transactions);
        TransactionReportGenerator.printExpensesByMonthsReport(expensesByMonth);

        Map<String, Double> expensesByCategory = TransactionAnalyzer.findExpensesByCategory(transactions);
        TransactionReportGenerator.printExpensesByCategoryReport(expensesByCategory);
    }
}
