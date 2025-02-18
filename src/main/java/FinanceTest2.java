import java.util.Scanner;

public class FinanceTest2 {
    private static final Dao dao = new Dao();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the transaction id: ");
        int transactionId = scanner.nextInt();

        Transaction transaction = dao.getTransaction(transactionId);
        System.out.println("Transaction Description: " + transaction.getTransactionDescription());
        System.out.println("Category: " + transaction.getCategoryId().getCategoryName());
        if (transaction.getSourceAccountId() != null) {
            System.out.println("Source Account Name: " + transaction.getSourceAccountId().getAccountName());
        }
        if (transaction.getDestinationAccountId() != null) {
            System.out.println("Destination Account Name: " + transaction.getDestinationAccountId().getAccountName());
        }
    }
}