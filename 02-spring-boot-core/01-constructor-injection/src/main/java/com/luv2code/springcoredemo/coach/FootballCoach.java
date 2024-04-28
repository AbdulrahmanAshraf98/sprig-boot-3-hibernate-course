package com.luv2code.springcoredemo.coach;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements CoachInterface{
    @Override
    public String goDailyWorkout() {
        return "daily work out 15  from football coach ";
    }
}
