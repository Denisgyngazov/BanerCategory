package test.BannerCategory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.google.common.collect.Sets;
import test.BannerCategory.controller.BannerController;
import test.BannerCategory.controller.CategoryController;
import test.BannerCategory.model.Banner;
import test.BannerCategory.model.Category;
import test.BannerCategory.repository.BannerRepository;
import test.BannerCategory.repository.CategoryRepository;
import test.BannerCategory.repository.RequestRepository;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
@Testcontainers
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BanerCategoryApplicationTests {

    @Container
    public static MySQLContainer mySQLContainer = new MySQLContainer("mysql:latest")
            .withDatabaseName("banercategory")
            .withUsername("root")
            .withPassword("my-secret-pw");

    @DynamicPropertySource
    static void mySQLProperties(DynamicPropertyRegistry registry) {
        mySQLContainer.start();
        registry.add("spring.datasource.url", mySQLContainer::getJdbcUrl);
        registry.add("spring.datasource.password", mySQLContainer::getPassword);
        registry.add("spring.datasource.username", mySQLContainer::getUsername);
    }

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BannerRepository bannerRepository;

    @Autowired
    private BannerController bannerController;

    @Autowired
    private CategoryController categoryController;

//    @BeforeAll
//    @Rollback
//    void contextLoads() {
//        Category category = new Category();
//        category.setName("test1");
//        category.setReq_name("test2");
//
//        Category category1 = new Category();
//        category1.setName("test2");
//        category1.setReq_name("test2");
//
//
//        Banner banner = new Banner(category);
//        banner.setName("first");
//        banner.setPrice(8.2);
//        banner.setText("");
//
//
//        Banner banner1 = new Banner(category);
//        banner1.setName("second");
//        banner1.setPrice(8.2);
//        banner1.setText("");
//
//        category.setBanners(Sets.newHashSet(banner,banner1));
//
//        categoryRepository.save(category);
//
//    }

//    @Test
//    public void createEntity() {
//        Iterable<Category> allCategory = categoryRepository.findAll();
//        allCategory.forEach(p -> System.out.println(p.getName() + " " + p.getId()));
//        System.out.println("-------------------------");
//        Iterable<Category> filterCategory = categoryRepository.findByNameLikeIgnoreCase("%da%");
//        filterCategory.forEach(p -> System.out.println(p.getName()));
//
//        Iterable<Banner> banerrepos = bannerRepository.findAll();
//        banerrepos.forEach(p -> System.out.println(p.getName() + " " + p.getCategory().getName() + " " + p.isDeleted()));
//
//    }

	@Test
	public void deleteCategory() {
		Category category = new Category();
		category.setName("test1");
		category.setReq_name("test2");

		Banner banner = new Banner(category);
		banner.setName("first");
		banner.setPrice(8.2);
		banner.setText("");


		Banner banner1 = new Banner(category);
		banner1.setName("second");
		banner1.setPrice(8.2);
		banner1.setText("");

		category.setBanners(Sets.newHashSet(banner,banner1));

        category = categoryRepository.save(category);

		Assertions.assertFalse(category.getBanners().isEmpty());
//        bannerController.delete(2);
//        bannerController.delete(3);
//        categoryController.delete(1,category);
	}
}
