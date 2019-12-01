package org.wjy.framework;

import org.wjy.framework.annotation.Api;
import org.wjy.framework.start.SpringApplication;

public class SpringBootApplication {

    @Api
    private static String api;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication.class);
        System.out.println(api);
    }

}
