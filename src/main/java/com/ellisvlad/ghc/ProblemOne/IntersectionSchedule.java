package com.ellisvlad.ghc.ProblemOne;

import java.util.ArrayList;
import java.util.List;

public class IntersectionSchedule {
    public Intersection intersection;
    public List<LightDuration> lightsDuration;

    public IntersectionSchedule(Intersection intersection) {
        this.intersection = intersection;
        this.lightsDuration = new ArrayList<>();
    }

    public boolean lightGreenForStreet(int time, String street) {
        int currentTime = 0;
        for (LightDuration lightDuration : lightsDuration) {
            if (time >= currentTime && time < currentTime + lightDuration.lightOnDuration && lightDuration.street == street) {
                return true;
            }
            currentTime += lightDuration.lightOnDuration;
        }
        return false;
    }
}