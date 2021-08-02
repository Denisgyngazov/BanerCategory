package test.BannerCategory.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@SQLDelete(sql = "UPDATE Banner SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Banner extends BaseModelEntity {

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    public Banner(Category category) {
        this.category = category;
    }

    public Banner() {
    }

    @Getter
    @Setter
    @Column(nullable = false, unique = true)
    @NotBlank(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String name;

    @Getter
    @Setter
    @Column(nullable = false)
    @NotEmpty
    @Min(value = 0, message = "Price should be greater than 0")
    private double price;

    @Getter
    @Setter
    @Column(nullable = false)
    @NotBlank(message = "Text should not be empty")
    private String text;

    @Getter
    @Setter
    @AssertFalse(message = "Deleted should be false")
    private boolean deleted = Boolean.FALSE;
}
