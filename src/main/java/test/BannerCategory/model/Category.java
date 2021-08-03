package test.BannerCategory.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@SQLDelete(sql = "UPDATE Category SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Table(name = "Category")
public class Category extends BaseModelEntity {

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Getter
    @Setter
    private Set<Banner> banners = new HashSet<>();

    @Getter
    @Setter
    @Column(nullable = false, unique = true)
    @NotBlank(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String name;

    @Getter
    @Setter
    @Column(nullable = false, unique = true)
    @NotBlank(message = "Req_name should not be empty")
    @Size(min = 2, max = 30, message = "Req_name should be between 2 and 30 characters")
    private String reqName;

    @Getter
    @Setter
    @AssertFalse(message = "Deleted should be false")
    private boolean deleted = Boolean.FALSE;
}
