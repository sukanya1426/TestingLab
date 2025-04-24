package math;

import io.FileIO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayOperationsTest {

    private ArrayOperations arrayOperations;
    private FileIO fileio;
    private MyMath myMath;

    @BeforeEach
    public void setup() {
        arrayOperations = new ArrayOperations();
        fileio = new FileIO();
        myMath = new MyMath();
    }

    @Test

    void findPrimesInFile() {
        int[] actual = arrayOperations.findPrimesInFile(fileio, "src/test/resources/prime.txt", myMath);


        int[] expected = {2, 3};
        assertArrayEquals(expected, actual);
    }

}
