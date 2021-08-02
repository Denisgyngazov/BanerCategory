package test.BannerCategory.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.BannerCategory.model.Category;
import test.BannerCategory.service.CategoryService;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    @SuppressWarnings("rawtypes")
    public ResponseEntity<Iterable> findAll() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody @Valid Category category) {
        return ResponseEntity.ok(categoryService.save(category));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable @Min(1) int id) {
        categoryService.delete(id);
    }

    @PutMapping("{update}")
    public ResponseEntity<Category> update(@RequestBody @Valid Category category) {
        return ResponseEntity.ok(categoryService.update(category));
    }

    @PostMapping("filter")
    public ResponseEntity<List<Category>> filter(@RequestParam @NotBlank String filter) {
        return ResponseEntity.ok(categoryService.filter(filter));
    }
}
