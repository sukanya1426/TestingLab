package math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyMathTest {

    MyMath obj;

    @BeforeEach
    public void setup ()throws Exception{
        obj = new MyMath();
    }
    @Test
    void normalfactorial() {
        int expected = 6;
        int actual = obj.factorial(3);
        assertEquals(expected,actual);
    }
    @Test
    void inputZeroFactorial() {
        int expected = 1;
        int actual = obj.factorial(0);
        assertEquals(expected,actual);
    }
    @Test
    void negativeInputFactorial() {

        assertThrows(IllegalArgumentException.class, () -> obj.factorial(-1));
    }
    @Test
    void higherInputFactorial() {
        assertThrows(IllegalArgumentException.class, () -> obj.factorial(12));
    }
    @Test
    void correctInputPrime() {
        boolean expected=true;
        boolean actual = obj.isPrime(19);
        assertEquals(expected,actual);
    }
    @Test
    void incorrectInputPrime() {
        boolean expected=false;
        boolean actual = obj.isPrime(7);
        assertEquals(expected,actual);
    }
    @Test
    void invalidInputPrime() {
        assertThrows(IllegalArgumentException.class,()->obj.isPrime(2));
    }

}