package org.example;

import java.util.Scanner;

public class TriangleHeight {
    public static void main(String[] args) {
        try {
            var triangle = new TriangleInputScannerReader(new Scanner(System.in)).readTriangle();
            new TriangleHeightWriter(triangle).printHeights();
        } catch (TriangleStateException e) {
            System.err.println(e.getMessage());
        }
    }
}