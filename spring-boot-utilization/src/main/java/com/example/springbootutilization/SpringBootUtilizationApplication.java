package com.example.springbootutilization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootUtilizationApplication {
    /**
     * 처음 스프링 부트 프로젝트를 만들면 1)처럼 어플리케이션을 정의하지만 저렇게 한다면 스프링부트가 제공하는 다양한 커스터마이징을 사용하기가 어렵다
     * 그래서 아래처럼 app 인스턴스를 만들고 run시켜도 동일하게 실행되고 커스터마이징 사용이 용이하게 된다.
     */

    public static void main(String[] args) {
//     1)   SpringApplication.run(SpringBootUtilizationApplication.class, args);
        SpringApplication app = new SpringApplication(SpringBootUtilizationApplication.class);
        app.addListeners(new SampleListener());
        app.run(args);

    }

}
