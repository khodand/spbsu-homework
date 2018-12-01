package group144.khodko;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LazyFactoryTest {
    @Test
    public void oneThreadLazyLogic() {
        testLazy(LazyFactory::createOneThreadLazy);
    }

    @Test
    public void multiThreadLazyLogic() {
        testLazy(LazyFactory::createMultiThreadLazy);
    }

    @Test
    public void multiThreadLazyConcurrent() throws InterruptedException {
        int n = 1000;
        CountingSupplier supplier = new CountingSupplier();
        Lazy<Integer> multiThreadLazy = LazyFactory.createMultiThreadLazy(supplier);
        CountDownLatch countDownLatch = new CountDownLatch(n);
        Supplier<Thread> tSup = () -> new Thread(() -> {
            countDownLatch.countDown();
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Integer value = multiThreadLazy.get();
            assertEquals(Integer.valueOf(1), value);
        });

        List<Thread> threads = Stream
                .generate(tSup)
                .limit(n)
                .peek(Thread::start)
                .collect(Collectors.toList());

        for (Thread thread : threads) {
            thread.join();
        }

        assertEquals(1, supplier.counter.get());
    }

    private void testLazy(Function<Supplier<Integer>, Lazy<Integer>> lazyFunction) {
        CountingSupplier countingSupplier = new CountingSupplier();
        Lazy<Integer> lazy = lazyFunction.apply(countingSupplier);
        assertEquals(0, countingSupplier.counter.get());
        assertEquals(Integer.valueOf(1), lazy.get());
        assertEquals(1, countingSupplier.counter.get());
        assertEquals(Integer.valueOf(1), lazy.get());
        assertEquals(Integer.valueOf(1), lazy.get());
        assertEquals(Integer.valueOf(1), lazy.get());
        assertEquals(1, countingSupplier.counter.get());

        assertNull(lazyFunction.apply(() -> null).get());
        assertEquals(Integer.valueOf(42), lazyFunction.apply(() -> 42).get());
    }

    private static class CountingSupplier implements Supplier<Integer> {

        private AtomicInteger counter = new AtomicInteger();

        @Override
        public Integer get() {
            return counter.incrementAndGet();
        }
    }
}