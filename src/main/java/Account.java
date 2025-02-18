import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "Account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AccountId", nullable = false)
    private int accountId;

    @Column(name = "AccountName", nullable = false)
    private String accountName;

    @Column(name = "Balance", nullable = false, precision = 15, scale = 2)
    private BigDecimal balance;

    public Account() {}

    public Account(String accountName, BigDecimal balance) {
        this.accountName = accountName;
        this.balance = balance;
    }

    public String getAccountName() {
        return accountName;
    }
}