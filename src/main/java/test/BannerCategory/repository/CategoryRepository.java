package test.BannerCategory.repository;

import org.springframework.data.repository.CrudRepository;
import test.BannerCategory.model.Category;

public interface CategoryRepository extends CrudRepository<Category,Integer> {
}
