package com.ellisvlad.ghc.ProblemOne.ellis;

import java.util.HashMap;
import java.util.Map;

import com.ellisvlad.ghc.ProblemOne.Street;

public class TrafficLightStates {

    public final Map<Street, Integer> timings = new HashMap<>();

	public TrafficLightStates(TrafficLightStatePair... pairs) {
		for (TrafficLightStatePair pair : pairs) {
            timings.put(pair.street, pair.duration);
        }
	}
 
    public static class TrafficLightStatePair {

        public final Street street;
        public final int duration;

        TrafficLightStatePair(Street street, int duration) {
            this.street = street;
            this.duration = duration;
        }

    }

}
