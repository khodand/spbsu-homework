package group144.khodko;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class SparseArrayTest {

    @Test
    public void input() {
        SparseArray vector = new SparseArray();
        vector.input(new Scanner("3 0 1 0 22 0 5 0"));

        assertEquals("3 0 1 0 22 0 5 0 ", vector.print());

    }

    @Test
    public void addition() {
        SparseArray vector1 = new SparseArray();
        SparseArray vector2 = new SparseArray();
        vector1.input(new Scanner("1 0 2 0 3"));
        vector2.input(new Scanner("3 0 5 1 1"));

        vector1.addition(vector2);

        assertEquals("4 0 7 1 4 ", vector1.print());
    }

    @Test
    public void subtraction() {
        SparseArray vector1 = new SparseArray();
        SparseArray vector2 = new SparseArray();
        vector1.input(new Scanner("1 0 2 0 3"));
        vector2.input(new Scanner("3 0 5 1 1"));

        vector1.subtraction(vector2);

        assertEquals("-2 0 -3 -1 2 ", vector1.print());
    }

    @Test
    public void dotProduct() {
        SparseArray vector1 = new SparseArray();
        SparseArray vector2 = new SparseArray();
        vector1.input(new Scanner("1 0 2 0 3"));
        vector2.input(new Scanner("3 0 5 1 1"));

        int result = vector1.dotProduct(vector2);
        assertEquals(16 , result);
    }

    @Test
    public void cloneTest() {
        SparseArray vector1 = new SparseArray();
        SparseArray vector2 = new SparseArray();
        vector1.input(new Scanner("3 0 1 0 22 0 5 0"));
        vector2.clone(vector1);

        assertEquals("3 0 1 0 22 0 5 0 ", vector2.print());

    }
}