package group144.khodko;

public class ArrayStack<ValueType>  implements Stack<ValueType> {

    private final int INITAL_SIZE = 10;

    private ValueType[] arr;
    private int size = 0;
    private int maxSize = INITAL_SIZE;

    ArrayStack() {
        arr = (ValueType[]) new Object[INITAL_SIZE];
    }

    @Override
    public void push(ValueType value) {
        if (size == maxSize) {
            resize(maxSize * 2);
            maxSize *= 2;
        }

        arr[size] = value;
        size++;
    }

    @Override
    public ValueType pop() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException("Stack is empty!");

        ValueType result = arr[size - 1];
        size--;

        if (size < maxSize / 2 && maxSize != INITAL_SIZE) {
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
       // System.arraycopy(arr, 0, newArr, 0, newSize);
        for (int i = 0; i < maxSize; ++i) {
            newArr[i] = arr[i];
        }

        arr = newArr;
    }
}
