package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.coach.CoachInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {
    private final CoachInterface myCoach;
    @Autowired
    public  CoachController(CoachInterface theCoach){
        this.myCoach=theCoach;
    }
    @GetMapping("/daily-workout")
    public  String getDailyWorkout(){
        return  this.myCoach.goDailyWorkout();
    }
}
