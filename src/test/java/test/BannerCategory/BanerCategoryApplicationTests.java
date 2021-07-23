package test.BannerCategory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import test.BannerCategory.controller.BannerController;
import test.BannerCategory.model.Banner;
import test.BannerCategory.model.Category;
import test.BannerCategory.model.Request;
import test.BannerCategory.repository.BannerRepository;
import test.BannerCategory.repository.CategoryRepository;
import test.BannerCategory.repository.RequestRepository;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BanerCategoryApplicationTests {

	@Autowired
	private RequestRepository requestRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private BannerRepository bannerRepository;

	@Autowired
	private BannerController bannerController;

	@Test
	@Rollback(value = false)
	void contextLoads() {
		Category category = new Category();
		category.setName("test");
		category.setReq_name("test2");
		category.setDeleted(false);

		Banner banner = new Banner(category);
		banner.setName("alala");
		banner.setPrice(8.2);
		banner.setText("shalalal");
		banner.setDeleted(false);


		Banner banner1 = new Banner(category);
		banner1.setName("alagfhgfhla");
		banner1.setPrice(8.2);
		banner1.setText("shalafghfghlal");
		banner1.setDeleted(false);

		Request request = new Request(banner);
		request.setDate("32");
		request.setIp_address("192.168");
		request.setUser_agent("admin");

		categoryRepository.save(category);


		bannerController.create(banner);

		//categoryRepository.save(category);
//		bannerRepository.save(banner);
//		bannerRepository.save(banner1);
//		requestRepository.save(request);

	}

}
