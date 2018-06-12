package group144.khodko;

/**
 * Class realizing sort based on ordinary quick sort algorithm.
 *
 * @param <T> Comparable type of array elements
 */
public class CommonQuicksort<T extends Comparable<T>> implements Sorter<T> {

    /**
     * @param array array will be sorted
     */
    @Override
    public void sort(T[] array) {
        recursiveQSort(array, 0, array.length - 1);
    }

    /**
     * Swap method
     * @param arr elements from here will be swapped
     * @param a indexes of this elements
     * @param b -//-
     */
    private void swap(T[] arr, int a, int b) {
        T temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * method that implements a recursive QSort algorithm
     * @param arr array to be sorted by parts
     * @param start first index of part
     * @param end last index of part
     */
    private void recursiveQSort(T[] arr, int start, int end) {
        if (end <= start) {
            return;
        }

        T mid = arr[(start + end) / 2];
        int i = start;
        int j = end;
        while (i <= j) {
            while (arr[i].compareTo(mid) < 0) {
                i++;
            }

            while (arr[j].compareTo(mid) > 0) {
                j--;
            }

            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        recursiveQSort(arr, start, i - 1);
        recursiveQSort(arr, i, end);
    }
}
