package group144.khodko;

import org.junit.Test;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class CommonQuicksortTest {

    @Test
    public void sortRandomTest() {
        Random random = new Random();
        Integer[] array = Stream.generate(() -> (random.nextInt()) % 100).limit(100).toArray(Integer[]::new);
        Integer[] sorted = Stream.of(array).sorted().toArray(Integer[]::new);
        Sorter<Integer> sorter = new CommonQuicksort<>();
        sorter.sort(array);
        assertArrayEquals(sorted, array);
    }

    @Test
    public void sortSortedTest() {
        Integer[] array = {1, 2, 3, 6, 7};
        Integer[] sorted = {1, 2, 3, 6, 7};
        Sorter<Integer> sorter = new CommonQuicksort<>();
        sorter.sort(array);
        assertArrayEquals(sorted, array);
    }

    @Test
    public void sortReverseTest() {
        Integer[] array = {9, 5, 5, 3, 2, 1};
        Integer[] sorted = {1, 2, 3, 5, 5, 9};
        Sorter<Integer> sorter = new CommonQuicksort<>();
        sorter.sort(array);
        assertArrayEquals(sorted, array);
    }

    @Test
    public void sortMonotonousTest() {
        Integer[] array = {1, 1, 1, 1, 1, 1, 1};
        Integer[] sorted = {1, 1, 1, 1, 1, 1, 1};
        Sorter<Integer> sorter = new CommonQuicksort<>();
        sorter.sort(array);
        assertArrayEquals(sorted, array);
    }

}