package io;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

class FileIOTest {

    FileIO obj =null;

    @BeforeEach
    public void setup() throws Exception{
        obj = new FileIO();
    }
    @Test
    void readFile() {
        int[] expected = {3, 9, 0, 2, 10, 9, 3, 8, 0, 3};
        int[] actual = obj.readFile("src/test/resources/grades_valid.txt");
        assertArrayEquals(expected, actual);
    }
    @Test
    void emptyFile() {
        assertThrows(IllegalArgumentException.class,()-> obj.readFile("src/test/resources/empty_file.txt"));

        }
//
    @Test
    void invalidNumber() {
        assertThrows(NumberFormatException.class,()-> obj.readFile("src/test/resources/grades_invalid.txt"));
    }

    @Test
    void wrongPath() {
        assertThrows(IllegalArgumentException.class,()-> obj.readFile("src/test/resources"));

    }

    @Test
    void specialNumber() {
        assertThrows(NumberFormatException.class,()-> obj.readFile("src/test/resources/special_character.txt"));
    }

}