package test.BannerCategory.repository;

import org.springframework.data.repository.CrudRepository;
import test.BannerCategory.model.Banner;

public interface BannerRepository extends CrudRepository<Banner,Integer> {
}
