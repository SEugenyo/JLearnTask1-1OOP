package org.example;

import java.util.Scanner;

public class TriangleInputScannerReader {
    private final Scanner inputScanner;

    public TriangleInputScannerReader(Scanner inputScanner) {
        this.inputScanner = inputScanner;
    }

    public double readTriangleSide(String inputPrompt) {
        System.out.print(inputPrompt);
        return inputScanner.nextDouble();
    }

    public Triangle readTriangle() throws TriangleStateException {
        double sideA = readTriangleSide("Введите длину стороны A: ");
        double sideB = readTriangleSide("Введите длину стороны B: ");
        double sideC = readTriangleSide("Введите длину стороны C: ");
        return new Triangle(sideA, sideB, sideC);
    }
}
