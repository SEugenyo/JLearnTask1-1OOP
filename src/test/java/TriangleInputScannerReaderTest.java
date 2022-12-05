import org.example.Triangle;
import org.example.TriangleInputScannerReader;
import org.example.TriangleStateException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TriangleInputScannerReaderTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void revertStreams() {
        System.setOut(standardOut);
    }

    @Test
    public void testReadTriangleSideFromString() {
        Scanner inputScanner = new Scanner("string");
        Assertions.assertThrows(InputMismatchException.class,
                () -> new TriangleInputScannerReader(inputScanner).readTriangleSide(""));
    }

    @Test
    public void testReadTriangleSideFromNumber() {
        Scanner inputScanner = new Scanner("123,33");
        Assertions.assertEquals(123.33,
                new TriangleInputScannerReader(inputScanner).readTriangleSide(""), 0.001);
    }

    @Test
    public void testReadTriangleSidePrompt() {
        Scanner inputScanner = new Scanner("0");
        new TriangleInputScannerReader(inputScanner).readTriangleSide("Test prompt");
        Assertions.assertEquals("Test prompt", outputStreamCaptor.toString().trim());
    }

    @Test
    public void testReadTriangle() throws TriangleStateException {
        Scanner inputScanner = new Scanner("""
                1
                1
                1""");
        Triangle triangle = new TriangleInputScannerReader(inputScanner).readTriangle();
        Assertions.assertEquals("Triangle{sideA=1.0, sideB=1.0, sideC=1.0}",
                triangle.toString());
    }
}
