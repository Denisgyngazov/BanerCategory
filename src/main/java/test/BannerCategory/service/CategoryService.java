package test.BannerCategory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import test.BannerCategory.model.Banner;
import test.BannerCategory.model.Category;
import test.BannerCategory.repository.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public void remove(int id, Category category){
        if(category.getBanners().isEmpty()) {
            categoryRepository.deleteById(id);
        } else {
            System.out.println("не могу удалить");

        }
    }

}
