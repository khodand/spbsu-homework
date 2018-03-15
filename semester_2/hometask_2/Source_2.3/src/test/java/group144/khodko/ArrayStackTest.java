package group144.khodko;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayStackTest {

    @Test
    public void pushEqualsPopTest() {
        Stack<Character> stack = new ArrayStack<>();

        for (Character i = 'a'; i < 'f'; ++i){
            stack.push(i);
        }
        for (Character i = 'e'; i >= 'a' ; --i) {
            assertEquals(i, stack.pop());
        }
    }

    @Test
    public void resizeTest() {
        Stack<Integer> stack = new ArrayStack<>();

        for (int i = 0; i < 14; ++i)
            stack.push(i);
        for (int i = 0; i < 10; ++i)
            stack.pop();
    }

    @Test
    public void isEmpty() {
        Stack<Integer> stack = new ArrayStack<>();

        for (int i = 0; i < 7; ++i)
            stack.push(i);
        assertEquals(false, stack.isEmpty());

        for (Character i = 0; i < 7 ; ++i)
            stack.pop();
        assertEquals(true, stack.isEmpty());
    }

    @Test(expected = EmptyStackException.class)
    public void EmpyStackExceptionTest() {
        Stack<Integer> stack = new ArrayStack<>();

        stack.push(11);
        stack.pop();
        stack.pop();
    }
}