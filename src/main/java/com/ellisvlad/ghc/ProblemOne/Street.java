package com.ellisvlad.ghc.ProblemOne;

public class Street {

    public final String streetName;
    public final Intersection startNode, endNode;
    public final int length;

	public Street(String streetName, Intersection startNode, Intersection endNode, int length) {
        this.streetName = streetName;
        this.startNode = startNode;
        this.endNode = endNode;
        this.length = length;
	}

}
