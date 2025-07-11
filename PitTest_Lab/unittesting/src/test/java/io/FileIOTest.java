package io;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class FileIOTest {
    private FileIO fileio;
    private final PrintStream originalErr = System.err;
    private ByteArrayOutputStream errContent;

    private FileIO fileIO = new FileIO();

    @Before
    public void setUp() throws Exception {
        errContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void tearDown() throws Exception {
        System.setErr(originalErr);
    }

    @Test
    public void readFile() {
        int[] expected = {3, 9, 0, 2, 10, 9, 3, 8, 0, 3};
        int[] actual = fileIO.readFile("src/test/resources/grades_valid.txt");
        assertArrayEquals(expected, actual);
    }

    @Test (expected = IllegalArgumentException.class)
    public void fileDoesNotExist() {
        fileIO.readFile("src/test/resources/grades.txt");
    }

    @Test (expected = IllegalArgumentException.class)
    public void fileIsEmpty() {
        fileIO.readFile("src/test/resources/empty_file.txt");
    }

    @Test (expected = NumberFormatException.class)
    public void invalidEntry() {
        fileIO.readFile("src/test/resources/grades_invalid.txt");
    }

    @Test
    public void test_io_exception() {
        File tempFile = new File("src/test/resources/restricted_file.txt");
        try {
            tempFile.createNewFile();
            tempFile.setReadable(false);
            assertThrows(IllegalArgumentException.class, () -> {
                fileIO.readFile(tempFile.getPath());
            });
            String errOutput = errContent.toString();
            assertTrue("Expected FileNotFoundException stack trace or Permission denied in System.err output",
                    errOutput.contains("java.io.FileNotFoundException") || errOutput.contains("Permission denied"));
        } catch (IOException e) {
            e.printStackTrace();
            fail("Failed to create test file: " + e.getMessage());
        } finally {
            tempFile.setReadable(true);
            tempFile.delete();
        }
    }

}