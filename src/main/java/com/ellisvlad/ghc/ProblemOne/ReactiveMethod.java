package com.ellisvlad.ghc.ProblemOne;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.lang.Integer;

public class ReactiveMethod {
    public InputParser inputParser;

    public ReactiveMethod(InputParser inputParser) {
        this.inputParser = inputParser;
    }

    // public void compute() {
    //     RoadMap roadMap = populateIntersectionSchedule();
    //     for (int currentTime = 1; currentTime <= inputParser.duration; currentTime++) {
    //         for(Intersection intersection : inputParser.nodeData) {
    //             intersection.outgoingStreets.stream().
    //             filter(street -> street.getCarsWaitingAtEnd().size() > 0).
    //             findFirst().
    //             ifPresentOrElse(f -> roadMap.addSchedule(intersection.id, f),
    //              () -> intersection.outgoingStreets.stream().findFirst().ifPresent(s -> roadMap.addSchedule(intersection.id, s)));
    //         }
    //         inputParser.carData.forEach(c -> {
    //             if (c.atEndOfStreet() && c.currentIntersection.)
    //         }); 
    //     }
    // }

    public List<IntersectionSchedule> compute() {
        RoadMap roadMap = populateIntersectionSchedule();
        for (int currentTime = 1; currentTime <= inputParser.duration; currentTime++) {
            for(Intersection intersection : inputParser.nodeData) {
            //    if(roadMap.intersectionSchedules.get(intersection.id).lightsDuration.size() == 0) {
                    roadMap.intersectionSchedules.get(intersection.id).lightsDuration.add(new LightDuration(intersection.outgoingStreets.stream().findAny().get().streetName, 1));
            //    }
            }
        }
        return new ArrayList<>(roadMap.intersectionSchedules.values());
    }

    public RoadMap populateIntersectionSchedule() {
        List<IntersectionSchedule> intersectionSchedules = new ArrayList<>();
        for(Intersection intersection : inputParser.nodeData) {
            intersectionSchedules.add(new IntersectionSchedule(intersection));
        }
        return new RoadMap(intersectionSchedules);
    }

    public static class RoadMap {
        private Map<Integer, IntersectionSchedule> intersectionSchedules;

        public RoadMap(List<IntersectionSchedule> intersectionSchedulesList) {
            this.intersectionSchedules = new HashMap<Integer, IntersectionSchedule>();
            intersectionSchedulesList.stream().forEach(i -> intersectionSchedules.put(i.intersection.id, i));
        }

        public void addSchedule(int intersection, Street street) {
            intersectionSchedules.get(intersection).lightsDuration.add(new LightDuration(street.streetName, 1));
        }
    }
}