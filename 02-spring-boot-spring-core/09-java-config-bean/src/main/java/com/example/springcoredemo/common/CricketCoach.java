package com.example.springcoredemo.common;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

    public CricketCoach(){
        System.out.println("CricketCoach constructor: "+ getClass().getSimpleName());
    }

    //define our init fn
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("doMyStartupStuff: ");
    }

    //define our destroy fn
    @PreDestroy
    public void doMyCleanStuff(){
        System.out.println("doMyCleanStuff: ");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes !!";
    }
}
