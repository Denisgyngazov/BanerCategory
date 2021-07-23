package test.BannerCategory.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Banner")
public class Banner extends BaseModelEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private double price;

    @Getter
    @Setter
    private String text;

    @Getter
    @Setter
    private boolean deleted;

    public Banner(Category category) {
        this.category = category;
    }

    public Banner() {
    }
}
