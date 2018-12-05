package group244.khodand;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/** Parallel quick sort. */
public class QuickSortParallel<T extends Comparable> implements SortingAlgorithm<T> {
    @Override
    public void sort(T[] array) {
        new ForkJoinPool().invoke(new ParallelRealization<T>(array, 0, array.length - 1));
    }

    private class ParallelRealization<T extends Comparable> extends RecursiveAction {
        private T[] array;
        private int left;
        private int right;

        public ParallelRealization(T[] array, int left, int right) {
            this.array = array;
            this.left = left;
            this.right = right;
        }

        private void swap(int i, int j) {
            T x = array[i];

            array[i] = array[j];
            array[j] = x;
        }

        @Override
        protected void compute() {
            if (left >= right) {
                return;
            }

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
                    swap(i, j);
                    i++;
                    j--;
                }
            }

            ParallelRealization<T> taskRight = new ParallelRealization<T>(array, i, right);
            ParallelRealization<T> taskLeft = new ParallelRealization<T>(array, left, j);

            taskRight.fork();
            taskLeft.compute();
            taskRight.join();
        }
    }
}