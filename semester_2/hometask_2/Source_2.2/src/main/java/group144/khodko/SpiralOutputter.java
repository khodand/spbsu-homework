package group144.khodko;

import java.io.PrintStream;

abstract class SpiralOutputter implements MatrixInterface {
    
    @Override
    void printSpiral(int[][] matrix, PrintStream stream) {
        int startIndex = matrix[0].length / 2;
        stream.print(matrix[startIndex][startIndex]);
        stream.print(" ");

        int leftBorder = startIndex;
        int upBorder = startIndex - 1;
        int rightBorder = startIndex;
        int downBorder = startIndex;

        int i = leftBorder;
        int j = upBorder;

        while (j >= 0) {
            while (i <= rightBorder) {
                stream.print(matrix[j][i]);
                stream.print(" ");
                ++i;
            }
            ++rightBorder;

            while (j <= downBorder) {
                stream.print(matrix[j++][i]);
                stream.print(" ");
            }
            ++downBorder;

            while (i >= leftBorder) {
                stream.print(matrix[j][i--]);
                stream.print(" ");
            }
            --leftBorder;

            while (j >= upBorder) {
                stream.print(matrix[j--][i]);
                stream.print(" ");
            }
            --upBorder;
        }
    }
}
