import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.system.*"})
@EntityScan(basePackages = {"com.system.*"})
@EnableJpaRepositories(basePackages = {"com.system.*"})
@EnableCaching
public class ApplicationRunner {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRunner.class);
    }
}
