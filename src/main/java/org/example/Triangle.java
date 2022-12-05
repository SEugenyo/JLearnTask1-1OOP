package org.example;

public class Triangle {
    public enum TRIANGLE_SIDE {
        A, B, C
    }

    private final double sideA;
    private final double sideB;
    private final double sideC;
    private final double heightFormulaNumerator;

    public Triangle(double sideA, double sideB, double sideC) throws TriangleStateException {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        validateTriangleSides();
        heightFormulaNumerator = calculateHeightFormulaNumerator();
    }

    private void validateTriangleSides() throws TriangleStateException {
        if (isAnySideLessOrEqualsZero()) {
            throw new TriangleStateException("Длина стороны должна быть больше нуля");
        }

        if (isAnySideGreaterOrEqualsSumOfOthers()) {
            throw new TriangleStateException("Сумма любых двух сторон треугольника должна быть больше третьей");
        }
    }

    private boolean isAnySideLessOrEqualsZero() {
        return (sideA <= 0) || (sideB <= 0) || (sideC <= 0);
    }

    private boolean isAnySideGreaterOrEqualsSumOfOthers() {
        return (sideC >= sideA + sideB) || (sideB >= sideA + sideC) || (sideA >= sideB + sideC);
    }

    private double calculateHeightFormulaNumerator() {
        double halfPerimeter = calculatePerimeter() / 2;
        return 2 * Math.sqrt(
                halfPerimeter * (halfPerimeter - sideA) * (halfPerimeter - sideB) * (halfPerimeter - sideC)
        );
    }

    private double calculatePerimeter() {
        return sideA + sideB + sideC;
    }

    public double calculateHeightToSide(TRIANGLE_SIDE side) {
        double sideTarget = getSide(side);
        return heightFormulaNumerator / sideTarget;
    }

    private double getSide(TRIANGLE_SIDE side) {
        return switch (side) {
            case A -> sideA;
            case B -> sideB;
            case C -> sideC;
        };
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "sideA=" + sideA +
                ", sideB=" + sideB +
                ", sideC=" + sideC +
                '}';
    }
}
