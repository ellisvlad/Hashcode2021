package com.ellisvlad.ghc.ProblemOne;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.util.List;

public class ResultWriter {
    public static void WriteResults(List<IntersectionSchedule> intersectionSchedules, DataOutputStream os) {
        System.out.println(intersectionSchedules.size());
        for (IntersectionSchedule schedule : intersectionSchedules) {
            System.out.println(schedule.intersection.id);
            System.out.println(schedule.lightsDuration.size());
            for (LightDuration lightDuration : schedule.lightsDuration) {
                System.out.println(lightDuration.street + " "+ lightDuration.lightOnDuration);
            }
        }
    }
}
