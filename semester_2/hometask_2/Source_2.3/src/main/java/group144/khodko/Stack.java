package group144.khodko;

public interface Stack<ValueType> {
    void push(ValueType value);
    ValueType pop() throws EmptyStackException;

    boolean isEmpty();
}
