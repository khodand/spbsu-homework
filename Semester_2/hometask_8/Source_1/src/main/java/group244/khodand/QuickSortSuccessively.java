package group244.khodand;

/** Successively quick sort. */
public class QuickSortSuccessively<T extends Comparable> implements SortingAlgorithm<T> {
    @Override
    public void sort(T[] array) {
        qSort(array, 0, array.length - 1);
    }

    private void qSort(T[] array, int left, int right) {
        int i = left;
        int j = right;

        T pivot = array[(i + j) / 2];

        while (i <= j) {
            while ((array[i].compareTo(pivot) < 0)) {
                i++;
            }
            while ((array[j].compareTo(pivot) > 0)) {
                j--;
            }

            if ((i <= j) && (array[i].compareTo(array[j]) >= 0)) {
                swap(array, i, j);
                i++;
                j--;
            }
        }

        if (i < right) {
            qSort(array, i, right);
        }

        if (j > left) {
            qSort(array, left, j);
        }
    }

    private void swap(T[] array, int i, int j) {
        T x = array[i];

        array[i] = array[j];
        array[j] = x;
    }
}