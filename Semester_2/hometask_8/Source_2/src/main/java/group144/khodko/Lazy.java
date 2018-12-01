package group144.khodko;

/**
 * Interface for lazy value supplier
 *
 * @param <T> value type parameter
 */
public interface Lazy<T> {
    /**
     * Lazily computes value and returns it
     *
     * @return value
     */
    T get();
}