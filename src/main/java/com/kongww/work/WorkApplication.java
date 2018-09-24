package com.kongww.work;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
// @MapperScan("com.kongww.work.mapper")
@ServletComponentScan
@tk.mybatis.spring.annotation.MapperScan(basePackages = "com.kongww.work.mapper")
public class WorkApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkApplication.class, args);
    }
}
