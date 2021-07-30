package test.BannerCategory.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@SQLDelete(sql = "UPDATE Banner SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Table(name = "Banner")
public class Banner extends BaseModelEntity {

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    public Banner(Category category) {
        this.category = category;
    }

    @Getter
    @Setter
    @Column(nullable = false)
    private String name;

    @Getter
    @Setter
    @Column(nullable = false)
    private double price;

    @Getter
    @Setter
    @Column(nullable = false)
    private String text;

    @Getter
    @Setter
    private boolean deleted = Boolean.FALSE;
}
