package wqz.model.sbmm.busproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableAutoConfiguration
@MapperScan(basePackages = "wqz.model.sbmm.busproject.mapper")
public class BusprojectApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BusprojectApplication.class, args);
    }
}
