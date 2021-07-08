package group244.khodand;

/** Sorting Algorithms interface. */
public interface SortingAlgorithm<T extends Comparable> {
    /** Sorting function. */
    void sort(T[] array);
}
