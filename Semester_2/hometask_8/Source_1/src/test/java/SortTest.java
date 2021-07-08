package group244.khodand;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import java.util.Random;

/** Sorting Algorithms test class. */
public class SortTest {
    private final int ARRAY_SIZE = 4194304;
    private Integer[] testingArray;

    /** Create array for sort. */
    @Before
    public void setUpSortingAlgorithm() {
        Random randomizer = new Random();
        testingArray = new Integer[ARRAY_SIZE];

        for (int i = 0; i < ARRAY_SIZE; i++) {
            testingArray[i] = randomizer.nextInt();
        }
    }

    /** Successively quick sort test */
    @Test
    public void successivelyTest() {
        SortingAlgorithm<Integer> testing = new QuickSortSuccessively<>();

        testing.sort(testingArray);

        checkArray("This is the end, Successively Sort doesn't work!", testingArray);
    }

    /** Parallel quick sort test */
    @Test
    public void parallelTest() {
        SortingAlgorithm<Integer> testing = new QuickSortParallel<>();

        testing.sort(testingArray);

        checkArray("We have some problems with Parallel Sort", testingArray);
    }

    private void checkArray(String message, Integer[] array) {
        for (int i = 0; i < array.length - 1; i++){
            Assert.assertTrue(message, array[i].compareTo(array[i + 1]) <= 0);
        }
    }
}