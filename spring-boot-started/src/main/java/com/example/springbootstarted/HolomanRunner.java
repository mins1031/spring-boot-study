package com.example.springbootstarted;

import min.prac.Holoman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class HolomanRunner implements ApplicationRunner {
    //ApplicationRunner는 스프링부트가 올라가고 자동으로 생성되는 빈을 만들고 싶을 때 사용한다고 한다.

    @Autowired
    private Holoman holoman;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(holoman);
    }
}
