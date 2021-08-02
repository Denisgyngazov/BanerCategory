package test.BannerCategory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.google.common.collect.Sets;
import test.BannerCategory.model.Banner;
import test.BannerCategory.model.Category;
import test.BannerCategory.service.BannerService;
import test.BannerCategory.service.CategoryService;

import java.util.List;

@SpringBootTest
@Testcontainers
@Validated
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
    private BannerService bannerService;

    @Autowired
    private CategoryService categoryService;

    @BeforeAll
    @Rollback()
    void contextLoads() {
        Category category = new Category();
        category.setName("First category");
        category.setReq_name("First");

        Banner banner = new Banner(category);
        banner.setName("First banner");
        banner.setPrice(8.2);
        banner.setText("FirstFirstFirstFirstFirstFirstFirstFirstFirstFirstFirstFirstFirstFirstFirstFirstFirstFirstFirst");


        Banner banner1 = new Banner(category);
        banner1.setName("Second banner");
        banner1.setPrice(9.2);
        banner1.setText("SecondSecondSecondSecondSecondSecondSecondSecondSecondSecondSecondSecondSecondSecondSecondSecond");

        category.setBanners(Sets.newHashSet(banner, banner1));

        categoryService.save(category);

    }

    @Test
    @Transactional
    public void createEntity() {
        System.out.println("Category:");
        System.out.println("-------------------------");
        Iterable<Category> allCategory = categoryService.findAll();
        allCategory.forEach(c -> System.out.println(c.getId() + " | "
                + c.getName() + " | "
                + c.getReq_name() + " | "
                + c.getBanners()));
        System.out.println("-------------------------");

        System.out.println("Banners:");
        System.out.println("-------------------------");
        Iterable<Banner> allBanners = bannerService.findAll();
        allBanners.forEach(b -> System.out.println(b.getId() + " | "
                + b.getName() + " | "
                + b.getPrice() + "| "
                + b.getText() + " | "
                + b.getCategory().getName()));
        System.out.println("-------------------------");

    }

    @Test
    public void filterBanners() {
        System.out.println("Filter banners:");
        System.out.println("-------------------------");
        List<Banner> filterBanners = bannerService.filter("%fir%");
        filterBanners.forEach(b -> System.out.println(b.getId() + " | "
                + b.getName()));
        System.out.println("-------------------------");
    }

    @Test
    public void filterCategory() {
        System.out.println("Filter category:");
        System.out.println("-------------------------");
        List<Category> filterCategory = categoryService.filter("%fi%");
        filterCategory.forEach(c -> System.out.println(c.getId() + " | "
                + c.getName()));
        System.out.println("-------------------------");
    }

    @Test
    @Transactional
    public void deleteCategory() {
        System.out.println("Delete category:");
        categoryService.delete(1);
    }
}
