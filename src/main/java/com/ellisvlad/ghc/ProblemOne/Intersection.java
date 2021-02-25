package com.ellisvlad.ghc.ProblemOne;

import java.util.HashSet;
import java.util.Set;

public class Intersection {
    public int id;
    public final Set<Street> outgoingStreets = new HashSet<>();

    public Intersection(int id) {
        this.id = id;
    }

}
