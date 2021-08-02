package test.BannerCategory.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.BannerCategory.model.Banner;
import test.BannerCategory.service.BannerService;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("banner")
public class BannerController {

    private final BannerService bannerService;

    public BannerController(BannerService bannerService) {
        this.bannerService = bannerService;
    }

    @GetMapping()
    @SuppressWarnings("rawtypes")
    public ResponseEntity<Iterable> findAll() {
        return ResponseEntity.ok(bannerService.findAll());
    }

    @PostMapping
    public ResponseEntity<Banner> create(@RequestBody @Valid Banner banner) {
        return ResponseEntity.ok(bannerService.save(banner));
    }

    @DeleteMapping("/{delete}")
    public void delete(@PathVariable @Min(1) int id) {
        bannerService.delete(id);
    }

    @PutMapping("/{update}")
    public ResponseEntity<Banner> update(@RequestBody @Valid Banner banner) {
        return ResponseEntity.ok(bannerService.update(banner));
    }

    @PostMapping("filter")
    public ResponseEntity<List<Banner>> filter(@RequestParam @NotBlank String filter) {
        return ResponseEntity.ok(bannerService.filter(filter));
    }
}
