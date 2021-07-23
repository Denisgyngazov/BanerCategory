package test.BannerCategory.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Category")
public class Category extends BaseModelEntity {
    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String req_name;

    @Getter
    @Setter
    private boolean deleted;
}
