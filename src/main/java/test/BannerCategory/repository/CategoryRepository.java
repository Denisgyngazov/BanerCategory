package test.BannerCategory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.BannerCategory.model.Category;

import java.util.List;


public interface CategoryRepository extends JpaRepository<Category, Integer> {

    List<Category> findByNameLikeIgnoreCase(String name);

}

