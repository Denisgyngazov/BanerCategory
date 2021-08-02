package test.BannerCategory.model;

import lombok.Getter;

import javax.persistence.*;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class BaseModelEntity {
    @Id
    @Column(name = "id")
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

}
