package test.BannerCategory.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import test.BannerCategory.model.Banner;

import java.util.List;

public interface BannerRepository extends CrudRepository<Banner, Integer> {

    List<Banner> findByNameLikeIgnoreCase(String name);

    @Query("select b from Banner b where b.category.reqName = :reqName and b.price >= all " +
            "(select ban.price from Banner ban where ban.category.reqName = :reqName) ")
    List<Banner> findByCategoryReqNameIgnoreCase(@Param("reqName") String reqName);

}
