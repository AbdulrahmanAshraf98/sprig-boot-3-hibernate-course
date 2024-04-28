package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.coach.CoachInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {
    private  CoachInterface myCoach;
    @Autowired
    public void setCoach(CoachInterface myCoach){
        this.myCoach=myCoach;
    }
    @GetMapping("/daily-workout")
    public  String getDailyWorkout(){
        return  this.myCoach.goDailyWorkout();
    }
}
