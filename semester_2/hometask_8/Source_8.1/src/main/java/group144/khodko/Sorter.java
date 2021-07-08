package group144.khodko;

/**
 * Interfase for sorting algos
 *
 * @param <T> Comparable type of array elements
 */
public interface Sorter<T extends Comparable<T>> {

    /**
     * Sort the array with default comparator.
     *
     * @param arr array will be sorted
     */
    void sort(T[] arr);
}
