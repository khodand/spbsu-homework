package group144.khodko;

public class QuickSort implements Sorter {
    @Override
    public void sort(int[] arr) {
        qsort(arr, 0, arr.length);
    }

    private void swap(int a, int b, int[] arr) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    private void qsort(int[] arr, int start, int end) {
        if (end - start <= 1)
            return;

        int mid = (start + end) / 2;
        swap(mid, start, arr);

        int min = start + 1;
        for (int i = start + 1; i < end; ++i) {
            if (arr[i] < arr[start]) {
                swap(min, i, arr);
                min++;
            }
        }
        swap(min - 1, start, arr);;

        qsort(arr, start, min - 1);
        qsort(arr, min, end);
    }
}
