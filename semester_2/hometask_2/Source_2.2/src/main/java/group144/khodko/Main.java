package group144.khodko;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int size = in.nextInt();
        System.out.println("Enter the array:");
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = in.nextInt();
            }
        }

        System.out.print("Print spiral to file (F) or console (C)?");
        switch(in.next()) {
            case "F": {
                MatrixInterface writer = new PrintToFile();
                writer.printSpiral(matrix);
                break;
            }
            case "C": {
                MatrixInterface writer = new PrintToConsole();
                writer.printSpiral(matrix);
                break;
            }
        }
    }
}
