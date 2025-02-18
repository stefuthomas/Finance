import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FinanceTest {
    private static Dao dao = new Dao();

    public static void main(String[] args) {
        Category foodCategory = new Category("Food");
        Category leisureCategory = new Category("Leisure");
        Category schoolCategory = new Category("School");
        Category giftsCategory = new Category("Gifts");
        Category internalTransferCategory = new Category("Internal Transfer");

        dao.saveCategory(foodCategory);
        dao.saveCategory(leisureCategory);
        dao.saveCategory(schoolCategory);
        dao.saveCategory(giftsCategory);
        dao.saveCategory(internalTransferCategory);

        Account savingsAccount = new Account("Savings", new BigDecimal("400.00"));
        Account walletAccount = new Account("Wallet", new BigDecimal("14.50"));
        dao.saveAccount(savingsAccount);
        dao.saveAccount(walletAccount);

        Transaction giftTransaction = new Transaction(new BigDecimal("100.00"), "Gift from Aunt Mary", LocalDateTime.now(), dao.getCategory(4), null, dao.getAccount(1));
        dao.saveTransaction(giftTransaction);

        Transaction internalTransfer = new Transaction(new BigDecimal("40.00"), "Transfer to wallet", LocalDateTime.now(), dao.getCategory(5), dao.getAccount(1), dao.getAccount(2));
        dao.saveTransaction(internalTransfer);

        Transaction pubTransaction = new Transaction(new BigDecimal("8.40"), "Pub", LocalDateTime.now(), dao.getCategory(2), dao.getAccount(2), null);
        dao.saveTransaction(pubTransaction);
    }
}