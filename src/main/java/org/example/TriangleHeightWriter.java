package org.example;

public class TriangleHeightWriter {
    private final Triangle triangle;

    public TriangleHeightWriter(Triangle triangle) {
        this.triangle = triangle;
    }

    public void printHeights() {
        printHeight(Triangle.TRIANGLE_SIDE.A);
        printHeight(Triangle.TRIANGLE_SIDE.B);
        printHeight(Triangle.TRIANGLE_SIDE.C);
    }

    public void printHeight(Triangle.TRIANGLE_SIDE side) {
        System.out.printf("H(%s): %.2f\n", side, triangle.calculateHeightToSide(side));
    }

}
