import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BankStatementAnalyzer {

    public static void analyze(final String fileName, final BankStatementParser bankStatementParser) throws IOException {
        final Path path = Paths.get(fileName);
        final List<String> lines = Files.readAllLines(path);
        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
        final BankTransactionProcessor bankTransactionProcessor = new BankTransactionProcessor(bankTransactions);
        collectSummary(bankTransactionProcessor);
    }

    private static void collectSummary(final BankTransactionProcessor bankTransactionProcessor) {
        System.out.println("Total amount for all transactions is " + bankTransactionProcessor.calculateTotalAmount());
        System.out.println("Total amount for description Salary is " + bankTransactionProcessor.calculateForCategory("Salary"));
        // System.out.println("Transactions in January is " + selectInMonth(bankTransactions, Month.JANUARY));
    }
}