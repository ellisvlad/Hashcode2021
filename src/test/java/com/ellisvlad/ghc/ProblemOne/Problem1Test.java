package com.ellisvlad.ghc.ProblemOne;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import com.ellisvlad.ghc.ProblemOne.ellis.SolutionWalker;

public class Problem1Test {

    @Test
    public void aTest() throws IOException {
        InputParser parser = new InputParser(ProblemOne.getFileInput("a.txt"));
        parser.parse();

        SolutionWalker solution = new SolutionWalker(parser);
        solution.walk();
    }

}
