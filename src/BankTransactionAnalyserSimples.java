import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BankTransactionAnalyserSimples {

    public static void main(final String... args) throws IOException {
        final BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();
        final Path path = Paths.get("src/extrato.csv");
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementCSVParser.parseLinesFromCSV(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        collectSummary(bankStatementProcessor);
    }

    private static void collectSummary(final BankStatementProcessor bankStatementProcessor) {
        System.out.println("Total amount for all transactions is " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("Total amount for description Salary is " + bankStatementProcessor.calculateForCategory("Salary"));
        // System.out.println("Transactions in January is " + selectInMonth(bankTransactions, Month.JANUARY));
    }
}