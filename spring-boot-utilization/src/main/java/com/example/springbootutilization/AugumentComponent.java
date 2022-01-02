package com.example.springbootutilization;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class AugumentComponent {

    public AugumentComponent(ApplicationArguments applicationArguments) {
        System.out.println("test " + applicationArguments.containsOption("foo"));
        System.out.println("test " + applicationArguments.containsOption("bar"));
    }
}
