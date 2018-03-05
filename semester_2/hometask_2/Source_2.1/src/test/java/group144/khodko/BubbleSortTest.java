package group144.khodko;

import org.junit.Test;
import static org.junit.Assert.*;

public class BubbleSortTest {

    @Test
    public void sortSorted() {
        int[] array = {1, 2, 3, 6, 7};
        int[] sorted = {1, 2, 3, 6, 7};
        Sorter sorter = new BubbleSort();
        sorter.sort(array);
        assertArrayEquals(sorted, array);
    }

    @Test
    public void sortReversed() {
        int[] array = {7, 6, 3, 2, 1};
        int[] sorted = {1, 2, 3, 6, 7};
        Sorter sorter = new BubbleSort();
        sorter.sort(array);
        assertArrayEquals(sorted, array);
    }

    @Test
    public void sortMonotonous() {
        int[] array = {1, 1, 1, 1, 1};
        int[] sorted = {1, 1, 1, 1, 1};
        Sorter sorter = new BubbleSort();
        sorter.sort(array);
        assertArrayEquals(sorted, array);
    }

    @Test
    public void sortRandomly() {
        int[] array = {3, 6, 1, 7, 2};
        int[] sorted = {1, 2, 3, 6, 7};
        Sorter sorter = new BubbleSort();
        sorter.sort(array);
        assertArrayEquals(sorted, array);
    }
}