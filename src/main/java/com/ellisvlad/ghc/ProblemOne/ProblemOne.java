package com.ellisvlad.ghc.ProblemOne;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class ProblemOne {

    public static BufferedReader getFileInput(String inputFile) {
        File file = new File("resources", inputFile);
        try {
            return new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.err.println("Could not open input file \"" + file + "\"");
            e.printStackTrace();
            System.exit(1);
        }

        return null;
    }

    public static BufferedReader getConsoleInput() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws Exception {
        ProblemOne runner = new ProblemOne(getFileInput("a.txt"));
        // ProblemOne runner = new ProblemOne(getConsoleInput());
    }

    public ProblemOne(BufferedReader is) throws IOException {
        InputParser parser = new InputParser(is);
        parser.parse();
        System.out.println("Done");
    }

}
