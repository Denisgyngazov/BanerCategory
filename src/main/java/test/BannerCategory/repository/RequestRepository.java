package test.BannerCategory.repository;

import org.springframework.data.repository.CrudRepository;
import test.BannerCategory.model.Request;

public interface RequestRepository extends CrudRepository<Request, Integer> {
}
