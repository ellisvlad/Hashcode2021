package com.ellisvlad.ghc.ProblemOne;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Street {

    public final String streetName;
    public final Intersection startNode, endNode;
	public final int length;
	public List<Car> cars;

	public Street(String streetName, Intersection startNode, Intersection endNode, int length) {
        this.streetName = streetName;
        this.startNode = startNode;
        this.endNode = endNode;
		this.length = length;
		this.cars = new ArrayList<>();
	}

	// public List<Car> getCarsWaitingAtEnd() {
	// 	return this.cars.stream().filter(c -> c.atEndOfStreet()).collect(Collectors.toList());
	// }

	public String toString() {
		return streetName;
	}
}
