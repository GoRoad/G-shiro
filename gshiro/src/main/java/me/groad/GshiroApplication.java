package me.groad;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("me.groad.mapper")
public class GshiroApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(GshiroApplication.class, args);
    }

}
