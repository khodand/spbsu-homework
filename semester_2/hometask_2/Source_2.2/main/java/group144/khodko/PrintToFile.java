package group144.khodko;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PrintToFile extends SpiralOutputter {
    public void printSpiral(int[][] matrix) throws FileNotFoundException {
        PrintStream out = new PrintStream("output.txt");
        printSpiral(matrix, out);
        out.close();
    }
}
