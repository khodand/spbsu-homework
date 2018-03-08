package group144.khodko;

public class BubbleSort implements Sorter {
    @Override
    public void sort(int[] arr) {
        int i = 0;
        boolean t = true;
        while (t) {
            t = false;
            for (int j = 0; j < arr.length - i - 1; ++j){
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1, arr);
                    t = true;
                }
            }
            i++;
        }
    }

    private void swap(int a, int b, int[] arr) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
