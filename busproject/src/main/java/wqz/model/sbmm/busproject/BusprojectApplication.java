package wqz.model.sbmm.busproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableAutoConfiguration
@MapperScan(basePackages = "wqz.model.sbmm.busproject.mapper")
@ComponentScan(basePackages = "wqz.model.sbmm.busproject")
public class BusprojectApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BusprojectApplication.class, args);
    }
}
