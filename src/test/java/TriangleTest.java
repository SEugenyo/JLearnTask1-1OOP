import org.example.Triangle;
import org.example.TriangleStateException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {
    @Test
    public void testCreateTriangleForLine() {
        TriangleStateException triangleStateException = Assertions.assertThrows(TriangleStateException.class,
                () -> new Triangle(1, 2, 3));
        Assertions.assertEquals("Сумма любых двух сторон треугольника должна быть больше третьей",
                triangleStateException.getMessage());
    }

    @Test
    public void testCreateTriangleForZero() {
        var triangleStateException = Assertions.assertThrows(TriangleStateException.class,
                () -> new Triangle(0, 2, 3));
        Assertions.assertEquals("Длина стороны должна быть больше нуля",
                triangleStateException.getMessage());
    }

    @Test
    public void testCreateTriangleForNegative() {
        var triangleStateException = Assertions.assertThrows(TriangleStateException.class,
                () -> new Triangle(-1, 2, 3));
        Assertions.assertEquals("Длина стороны должна быть больше нуля",
                triangleStateException.getMessage());
    }

    @Test
    public void testCalculateHeightToSideA() throws TriangleStateException {
        Assertions.assertEquals(12.990,
                new Triangle(15, 15, 15).calculateHeightToSide(Triangle.TRIANGLE_SIDE.A),
                0.001);
    }
}
