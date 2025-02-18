import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="Transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="TransactionId", nullable=false)
    private int transactionId;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal amount;

    @Column(name="Description")
    private String description;

    @Column(nullable = false, updatable = false)
    private LocalDateTime timestamp;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="CategoryId", nullable=false)
    private Category categoryId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="SourceAccountId")
    private Account sourceAccountId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="DestinationAccountId")
    private Account destinationAccountId;

    public Transaction() {}

    public Transaction(BigDecimal amount, String description, LocalDateTime timestamp, Category categoryId, Account sourceAccountId, Account destinationAccountId) {
        this.amount = amount;
        this.description = description;
        this.timestamp = timestamp;
        this.categoryId = categoryId;
        this.sourceAccountId = sourceAccountId;
        this.destinationAccountId = destinationAccountId;
    }

    public String getTransactionDescription() {
        return description;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public Account getSourceAccountId() {
        return sourceAccountId;
    }

    public Account getDestinationAccountId() {
        return destinationAccountId;
    }
}