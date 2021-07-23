package test.BannerCategory.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import test.BannerCategory.model.Banner;
import test.BannerCategory.repository.BannerRepository;

@RestController
@RequestMapping("/banner")
public class BannerController {

    private BannerRepository bannerRepository;

    public BannerController(BannerRepository bannerRepository) {
        this.bannerRepository = bannerRepository;
    }

    @GetMapping()
    public Iterable findAll() {
        return bannerRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Banner create(@RequestBody Banner banner) {
        return bannerRepository.save(banner);
    }

    @DeleteMapping("/{delete}")
    public void delete(@PathVariable int id) {
        bannerRepository.findById(id);
        bannerRepository.deleteById(id);
    }

    @PutMapping("/{update}")
    public Banner updateBanner(@RequestBody Banner banner, @PathVariable int id) {
        if(banner.getId() != id) {
            System.out.println("Несоответсвие id");
        }
        bannerRepository.findById(id);
        return bannerRepository.save(banner);
    }




}
