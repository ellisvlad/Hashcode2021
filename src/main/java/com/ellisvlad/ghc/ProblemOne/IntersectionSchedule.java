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
}