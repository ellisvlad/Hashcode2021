package com.ellisvlad.ghc.ProblemOne;

import java.util.Deque;
import java.util.List;
import java.util.Queue;

public class Car {
	public final Intersection currentIntersection;
    public final Deque<Street> streetsPath;
    public int distanceAlongStreet;
    public Street startStreet;
    public Street currentStreet;

    public Car(Deque<Street> streetsPath, Intersection startIntersection, Street startStreet) {
        this.streetsPath = streetsPath;
        this.currentIntersection = startIntersection;
        this.distanceAlongStreet = 0;
        this.startStreet = startStreet;
        this.currentStreet = startStreet;
    }
    
    public boolean atEndOfStreet() {
        return distanceAlongStreet == currentStreet.length;
    }

}
