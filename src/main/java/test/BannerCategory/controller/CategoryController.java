package test.BannerCategory.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import test.BannerCategory.model.Banner;
import test.BannerCategory.model.Category;
import test.BannerCategory.repository.CategoryRepository;
import test.BannerCategory.service.CategoryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("category")
public class CategoryController {
    private CategoryRepository categoryRepository;
    private CategoryService categoryService;

    public CategoryController(CategoryRepository categoryRepository,CategoryService categoryService) {
        this.categoryRepository = categoryRepository;
        this.categoryService = categoryService;
    }

    @GetMapping
    public Iterable findAll() {
        return categoryRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category create(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id, @RequestBody Category category) {
        categoryService.remove(id, category);
    }

    @PutMapping("{update}")
    public Category updateBanner(@RequestBody Category category, @PathVariable int id) {
        if(category.getId() != id) {
            System.out.println("Несоответсвие id");
        }
        categoryRepository.findById(id);
        return categoryRepository.save(category);
    }

    @PostMapping("filter")
    public List<Category> filter(@RequestParam String filter) {
        return categoryRepository.findByNameLikeIgnoreCase(filter);
    }
}
