package test.BannerCategory.repository;

import org.springframework.data.repository.CrudRepository;
import test.BannerCategory.model.Category;

import java.util.List;


public interface CategoryRepository extends CrudRepository<Category, Integer> {

    List<Category> findByNameLikeIgnoreCase(String name);
}

