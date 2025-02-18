import jakarta.persistence.*;

@Entity
@Table(name="Category")
public class Category {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="CategoryId", nullable=false)
    private int categoryId;

    @Column(name="CategoryDescription")
    private String categoryDescription;


    public Category() {}

    public Category(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public String getCategoryName() {
        return categoryDescription;
    }
}