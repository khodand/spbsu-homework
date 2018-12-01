package group144.khodko;

import java.util.function.Supplier;

/**
 * Factory for one and multi thread lazy suppliers
 */
public class LazyFactory {

    /**
     * Create not thread safe lazy supplier
     *
     * @param supplier supplier to make lazy
     * @param <T>      type of object in supplier
     * @return not thread safe lazy supplier
     */
    public static <T> Lazy<T> createOneThreadLazy(Supplier<T> supplier) {
        return new OneThreadLazy<>(supplier);
    }

    /**
     * Create thread safe lazy supplier
     *
     * @param supplier supplier to make lazy
     * @param <T>      object type in supplier
     * @return         thread safe lazy supplier
     */
    public static <T> Lazy<T> createMultiThreadLazy(Supplier<T> supplier) {
        return new MultiThreadLazy<>(supplier);
    }

    /**
     * Do supplier in one thread
     * @param <T> object type in supplier
     */
    private static class OneThreadLazy<T> implements Lazy<T> {

        private final Supplier<T> supplier;
        private T result = null;
        private boolean isComputed = false;

        public OneThreadLazy(Supplier<T> supplier) {
            this.supplier = supplier;
        }
        @Override
        public synchronized T get() {
            if (!isComputed) {
                this.isComputed = true;
                result = supplier.get();
            }
            return result;
        }
    }

    /**
     * Do supplier in multithread
     * @param <T> object type in supplier
     */
    private static class MultiThreadLazy<T> implements Lazy<T> {
        private final Supplier<T> supplier;
        private T result = null;
        private volatile boolean isComputed = false;

        public MultiThreadLazy(Supplier<T> supplier) {
            this.supplier = supplier;
        }

        @Override
        public T get() {
            if (!isComputed) {
                synchronized (this) {
                    if (!isComputed) {
                        result = supplier.get();
                        isComputed = true;
                    }
                }
            }
            return result;
        }
    }
}