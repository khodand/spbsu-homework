package group144.khodko;


public class LinkStack<ValueType> implements Stack<ValueType> {
    private class StackElement {
        ValueType value;
        StackElement next = null;

        StackElement() { }

        StackElement(ValueType value, StackElement next) {
            this.value = value;
            this.next = next;
        }
    }

    private StackElement top = null;

    LinkStack() { }

    @Override
    public void push(ValueType value) {
        top = new StackElement(value, top);
    }

    @Override
    public ValueType pop() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException("Stack is empty!");

        ValueType result = top.value;
        top = top.next;
        return result;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }
}
