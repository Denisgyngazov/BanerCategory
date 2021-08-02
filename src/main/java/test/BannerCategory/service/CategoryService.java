package test.BannerCategory.service;

import org.springframework.stereotype.Service;
import test.BannerCategory.exceptions.CategoryNotFoundException;
import test.BannerCategory.model.Category;
import test.BannerCategory.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void delete(int id) {
        Category category = categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new);
        if (category.getBanners().isEmpty()) {
            categoryRepository.deleteById(id);
        } else {
            System.out.println("Don't remove, " + "Category use banners witch id: ");
            category.getBanners().forEach(b -> System.out.println(b.getId()));
        }
    }

    @SuppressWarnings("rawtypes")
    public Iterable findAll() {
        return categoryRepository.findAll();
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public Category update(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> filter(String filter) {
        return categoryRepository.findByNameLikeIgnoreCase(filter);
    }
}
