package group144.khodko;

public class PrintToConsole extends SpiralOutputter {
    @Override
    public void printSpiral(int[][] matrix) {
        printSpiral(matrix, System.out);
    }
}
