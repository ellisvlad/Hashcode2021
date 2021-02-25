package com.ellisvlad.ghc.ProblemOne.ellis;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.ellisvlad.ghc.ProblemOne.InputParser;
import com.ellisvlad.ghc.ProblemOne.Intersection;
import com.ellisvlad.ghc.ProblemOne.Street;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;

public class SolutionWalker {

    private final InputParser input;

    public SolutionWalker(InputParser input) {
        this.input = input;
    }

    public void walk() {
        Multimap<Integer, Street> intersections = HashMultimap.create();
        Map<NodeStreetPair, EarliestGreen> earliestGreens = new HashMap<>();
        input.carData.forEach(car -> {
            Deque<Street> streetsPath = new ArrayDeque<>(car.streetsPath);
            streetsPath.removeLast();
            
            Street firstStreet = streetsPath.peek();
            earliestGreens.put(new NodeStreetPair(firstStreet.endNode.id, firstStreet), new EarliestGreenStart());

            streetsPath.forEach(street -> {
                intersections.put(street.endNode.id, street);
            });
        });

        earliestGreens.forEach((p, g) -> System.out.println(p.street.streetName + "(" + p.node + ") 0"));

        Map<Integer, TrafficLightStates> lights = new HashMap<>();
        // Get all single intersection streets
        intersections.asMap().forEach((node, streets) -> {
            if (streets.size() == 1) {
                lights.put(node, new TrafficLightStates(new TrafficLightStates.TrafficLightStatePair(streets.iterator().next(), 1)));
            }
        });
        // Get all multiple intersection streets
        intersections.asMap().forEach((node, streets) -> {
            if (streets.size() > 1) {
                System.out.println("TODO: " + node + " : " + streets);
            }
        });

        // Output
        System.out.println(lights.size());
        lights.forEach((light, state) -> {
            System.out.println(light);
            System.out.println(state.timings.size());
            state.timings.forEach((street, duration) -> {
                System.out.println(street.streetName + " " + duration);
            });
        });
    }

    public static class NodeStreetPair {

        public final int node;
        public final Street street;

        NodeStreetPair(int node, Street street) {
            this.node = node;
            this.street = street;
        }

    }

    public static abstract class EarliestGreen {
    }

    public static class EarliestGreenStart extends EarliestGreen {
    }

}
