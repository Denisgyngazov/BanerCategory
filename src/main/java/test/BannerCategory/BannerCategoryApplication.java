package test.BannerCategory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("test.BannerCategory.model")
@EnableJpaRepositories("test.BannerCategory.repository")
@SpringBootApplication
public class BannerCategoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BannerCategoryApplication.class, args);
	}

}
