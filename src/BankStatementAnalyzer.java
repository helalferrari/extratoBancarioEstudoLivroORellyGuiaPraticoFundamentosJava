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
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
        collectSummary(bankStatementProcessor);
    }

    private static void collectSummary(final BankStatementProcessor bankStatementProcessor) {
        System.out.println("Total amount for all transactions is " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("Total amount for description Salary is " + bankStatementProcessor.calculateForCategory("Salary"));
        // System.out.println("Transactions in January is " + selectInMonth(bankTransactions, Month.JANUARY));
    }
}