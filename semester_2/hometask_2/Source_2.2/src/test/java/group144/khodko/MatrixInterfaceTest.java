package group144.khodko;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.Assert.*;

public class MatrixInterfaceTest {

    @Test
    public void consolePrint() throws FileNotFoundException {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(arrayOutputStream));

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        MatrixInterface writer = new PrintToConsole();
        writer.printSpiral(matrix);

        String answer = "5 2 3 6 9 8 7 4 1 ";
        assertEquals(answer, arrayOutputStream.toString());
    }

    @Test
    public void OneElementMatrix() throws FileNotFoundException {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(arrayOutputStream));

        int[][] matrix = {{1}};
        MatrixInterface writer = new PrintToConsole();
        writer.printSpiral(matrix);

        String answer = "1 ";
        assertEquals(answer, arrayOutputStream.toString());
    }

    @Test
    public void filePrint() throws FileNotFoundException {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        MatrixInterface writer = new PrintToFile();
        writer.printSpiral(matrix);

        Scanner file = new Scanner(new File("output.txt"));
        file.useDelimiter("\n");

        String answer = "5 2 3 6 9 8 7 4 1 ";
        assertEquals(answer, file.nextLine());
    }
}