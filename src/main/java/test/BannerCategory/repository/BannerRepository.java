package test.BannerCategory.repository;

import org.springframework.data.repository.CrudRepository;
import test.BannerCategory.model.Banner;

import java.util.List;

public interface BannerRepository extends CrudRepository<Banner, Integer> {

    List<Banner> findByNameLikeIgnoreCase(String name);

    List<Banner> findFirstByCategoryReqNameOrderByPriceDesc(String reqName);

}
