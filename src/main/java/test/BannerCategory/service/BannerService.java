package test.BannerCategory.service;

import org.springframework.stereotype.Service;
import test.BannerCategory.model.Banner;
import test.BannerCategory.repository.BannerRepository;

import java.util.List;

@Service
public class BannerService {

    private final BannerRepository bannerRepository;

    public BannerService(BannerRepository bannerRepository) {
        this.bannerRepository = bannerRepository;
    }

    @SuppressWarnings("rawtypes")
    public Iterable findAll() {
        return bannerRepository.findAll();
    }

    public Banner save(Banner banner) {
        return bannerRepository.save(banner);
    }

    public void delete(int id) {
        bannerRepository.deleteById(id);
    }

    public Banner update(Banner banner) {
        return bannerRepository.save(banner);
    }

    public List<Banner> filter(String filter) {
        return bannerRepository.findByNameLikeIgnoreCase(filter);
    }
}
