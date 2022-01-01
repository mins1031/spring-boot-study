package com.example.springbootstarted;

import min.prac.Holoman;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootStartedApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStartedApplication.class, args);
    }

    @Bean
    public Holoman holoman() {
        Holoman holoman = new Holoman();
        holoman.setName("min");
        holoman.setHowLong(150);
        return holoman;
    }
    //spring-boot-autoconfig 프로젝트에서 만든 holoman을 maven install하면 로컬 메이븐 레포지토리에 저장된다고 한다.
    //저장한 파일을 해당 started프로젝트에서 가져와 사용할수 있게되었다.
    //해서 어플리케이션을 런시키면 HoloRunner의 내용이 실행되게 된다
    //그런데 만약 위처럼 따로 Holoman을 또 빈으로 등록해서 올리면 어떻게 될까
    //-> 기존 Holoman이 덮어쓴다고 한다.(위의 빈이 아닌 기존의 빈) 어떻게 해결할까?
    //autoconfig 어플리케이션의 Holoman을 빈으로 등록하는 설정에 @ConditionalOnMissingBean를 추가해주면 현 프로젝트에서 등록하는 빈을 우선 등록 해준다.
}
