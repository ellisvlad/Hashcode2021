package com.ellisvlad.ghc.ProblemOne;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {

    private final BufferedReader is;

    private final Pattern lineOnePattern = Pattern.compile("(\\d+) (\\d+) (\\d+) (\\d+) (\\d+)");
    private final Pattern streetPattern = Pattern.compile("(\\d+) (\\d+) (.+) (\\d+)");

    public int duration;
    public int intersections;
    public int streets;
    public int cars;
    public int bonus;

    public List<Intersection> nodeData;
    public Map<String, Street> streetData;
    public List<Car> carData;

    public InputParser(BufferedReader is) {
        this.is = is;
    }

    protected void parse() throws IOException {
        Matcher lineOne = lineOnePattern.matcher(is.readLine());
        if (!lineOne.matches()) throw new RuntimeException("Line 1 was in invalid form!");

        duration = Integer.parseInt(lineOne.group(1));
        intersections = Integer.parseInt(lineOne.group(2));
        streets = Integer.parseInt(lineOne.group(3));
        cars = Integer.parseInt(lineOne.group(4));
        bonus = Integer.parseInt(lineOne.group(5));

        nodeData = new ArrayList<>(intersections);
        for (int i=0; i<intersections; i++) {
            nodeData.add(new Intersection(i));
        }

        streetData = new HashMap<>();
        for (int i=0; i<streets; i++) {
            Matcher streetMatch = streetPattern.matcher(is.readLine());
            if (!streetMatch.matches()) throw new RuntimeException("Street had invalid form!");

            int startNode = Integer.parseInt(streetMatch.group(1));
            int endNode = Integer.parseInt(streetMatch.group(2));
            String streetName = streetMatch.group(3);
            int length = Integer.parseInt(streetMatch.group(4));

            Street street = new Street(streetName, nodeData.get(startNode), nodeData.get(endNode), length);
            streetData.put(streetName, street);
            nodeData.get(startNode).outgoingStreets.add(street);
        }

        carData = new ArrayList<>(cars);
        for (int i=0; i<cars; i++) {
            String[] parts = is.readLine().split(" ");

            Deque<Street> streetsPath = new ArrayDeque<>(Integer.parseInt(parts[0]));
            for (int j = 1; j != parts.length; j++) {
                streetsPath.add(streetData.get(parts[j]));
            }

            carData.add(new Car(streetsPath, streetsPath.peek().startNode, streetsPath.peek()));
        }
    }

}
