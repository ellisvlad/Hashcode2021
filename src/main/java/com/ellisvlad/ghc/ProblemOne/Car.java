package com.ellisvlad.ghc.ProblemOne;

import java.util.List;
import java.util.Queue;

public class Car {

	public final Intersection currentIntersection;
    public final Queue<Street> streetsPath;

    public Car(Queue<Street> streetsPath, Intersection startIntersection) {
        this.streetsPath = streetsPath;
        this.currentIntersection = startIntersection;
	}

}
