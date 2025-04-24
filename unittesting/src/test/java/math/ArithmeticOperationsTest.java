package math;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticOperationsTest {

    ArithmeticOperations obj;

    @BeforeEach
    public void setup ()throws Exception{
        obj = new ArithmeticOperations();
    }

    @Test
    public void testDivideNormalCase() {
        double result = obj.divide(1000000, 2);
        assertEquals(500000, result, 0.0001);
    }

    @Test
    public void testDivideFirstNegativeNumbers() {
        double result = obj.divide(-10, 2);
        assertEquals(-5.0, result, 0.0001);
    }
    @Test
    public void testDivideSecNegativeNumbers() {
        double result = obj.divide(10, -2);
        assertEquals(-5.0, result, 0.0001);
    }
    @Test
    public void testDivideFirstZeroNumbers() {
        double result = obj.divide(0, -2);
        assertEquals(0, result, 0.0001);
    }

    @Test
    public void testDivideByZeroException() {
        assertThrows(ArithmeticException.class, () -> obj.divide(10, 0));
    }

    @Test
    public void testMultiplyNormalCase() {
        int result1 = obj.multiply(4, 5);
        assertEquals(20, result1);

    }

    @Test
    public void testMultiplyByZero() {
        int result2 = obj.multiply(7, 0);
        assertEquals(0, result2);
    }

    @Test
    public void testMultiplyFirstNoNegativeException() {
        assertThrows(IllegalArgumentException.class, () -> obj.multiply(-3, 5));
    }
    @Test
    public void testMultiplySecNoNegativeException() {
        assertThrows(IllegalArgumentException.class, () -> obj.multiply(3, -5));
    }
    @Test
    public void testMultiplyBothNoNegativeException() {
        assertThrows(IllegalArgumentException.class, () -> obj.multiply(-3, -5));
    }
    @Test
    public void testMultiplyFirstNotIntegerException() {
        assertThrows(IllegalArgumentException.class, () ->
                obj.multiply(Integer.MAX_VALUE, 3));
    }
    @Test
    public void testMultiplySecNotIntegerException() {
        assertThrows(IllegalArgumentException.class, () ->
                obj.multiply(3, Integer.MAX_VALUE));
    }
    @Test
    public void testMultiplyBothNotIntegerException() {
        assertThrows(IllegalArgumentException.class, () ->
                obj.multiply(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }
    @Test
    public void testMultiplyMaxMinIntegerException() {
        assertThrows(IllegalArgumentException.class, () ->
                obj.multiply(Integer.MAX_VALUE, Integer.MIN_VALUE));
    }
}