package group144.khodko;

import java.util.Arrays;

import java.util.Random;
import java.util.stream.Stream;

/**
 * Class realizing compares the execution time of two sorts
 */
public class SpeedTest {

    private final int ARRAY_LENGTH = 10000;
    private final int TESTS_NUMBER = 100;
    private final int filterPercent = 5;

    private final long[] timeData = new long[TESTS_NUMBER];

    /**
     * Main method shows statistic of test
     */
    public void showStats() {
        long commonTime = mean(new CommonQuicksort<>());
        System.out.println("Common QS(ms): " + commonTime);
        long parallelTime = mean(new ParallelQuicksort<>());
        System.out.println("Parallel QS(ms): " + parallelTime);
        System.out.println("diff(ms): " + (commonTime - parallelTime));
        System.out.println("%: " + (parallelTime * 100.0 / commonTime));
    }

    /**
     * method thats counting average time of sort execution
     */
    private long mean(Sorter sorter) {
        for (int i = 0; i < TESTS_NUMBER; i++) {
            Random random = new Random();
            Integer[] arr = Stream.generate(() ->
                    (random.nextInt()) % 100).limit(ARRAY_LENGTH).toArray(Integer[]::new);

            long time = System.currentTimeMillis();
            sorter.sort(arr);
            timeData[i] = System.currentTimeMillis() - time;
        }

        Arrays.sort(timeData);
        long mean = 0;
        int count = 0;
        for (int i = TESTS_NUMBER * filterPercent / 100; i < TESTS_NUMBER * (100 - filterPercent) / 100; i++) {
            mean += timeData[i];
            count++;
        }

        return mean / count;
    }
}
