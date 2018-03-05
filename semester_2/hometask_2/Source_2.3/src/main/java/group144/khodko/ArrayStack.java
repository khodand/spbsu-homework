package group144.khodko;

public class ArrayStack<ValueType> implements Stack<ValueType> {

    private final int INITIAL_SIZE = 10;

    private ValueType[] stackElements = (ValueType[]) new Object[INITIAL_SIZE];
    private int size = 0;
    private int maxSize = INITIAL_SIZE;

    ArrayStack() { }

    @Override
    public void push(ValueType value) {
        if (size == maxSize) {
            resize(maxSize * 2);
            maxSize *= 2;
        }

        stackElements[size] = value;
        size++;
    }

    @Override
    public ValueType pop() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException("Stack is empty!");

        ValueType result = stackElements[size - 1];
        size--;

        if (size < maxSize / 2 && maxSize != INITIAL_SIZE) {
            maxSize /= 2;
            resize(maxSize);
        }
        return result;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int newSize) {
        ValueType[] newArr = (ValueType[]) new Object[newSize];
        for (int i = 0; i < maxSize; ++i) {
            newArr[i] = stackElements[i];
        }

        stackElements = newArr;
    }
}
