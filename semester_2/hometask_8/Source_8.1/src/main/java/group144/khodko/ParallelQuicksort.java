package group144.khodko;

import java.util.concurrent.*;

/**
 * Class realizing sort based on multi-thread quick sort algorithm.
 *
 * @param <T> Comparable type of array elements
 */
public class ParallelQuicksort<T extends Comparable<T>> implements Sorter<T> {

    /**
     * @param array array will be sorted
     */
    @Override
    public void sort(T[] array) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(new RecursiveQSort(array, 0, array.length - 1));
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

    /** Class with recursive QSort*/
    private class RecursiveQSort extends RecursiveAction {
        private T[] arr;
        private int start;
        private int end;

        /**
         * RecursiveQSort Constructor
         *
         * @param arr that will be sorted by parts
         * @param start start index of this part
         * @param end end index of this part
         */
        public RecursiveQSort(T[] arr, int start, int end) {
            this.arr = arr;
            this.start = start;
            this.end = end;
        }

        /** recursive QSort algorithm actually */
        @Override
        public void compute() {
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

            RecursiveQSort leftPart = new RecursiveQSort(arr, start, i - 1);
            RecursiveQSort rightPart = new RecursiveQSort(arr, i, end);

            rightPart.fork();
            leftPart.compute();
            rightPart.join();

        }
    }

}