package group144.khodko;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListTest {

    @Test
    public void addTest() throws ElementAlreadyAddedException, NullElementException {
        List<Integer> list = new List<>();
        list.add(101);
        list.add(22);
        list.add(33);
        assertEquals(Integer.valueOf(22), list.remove(1));
        assertEquals(Integer.valueOf(33), list.pop());
        assertEquals(Integer.valueOf(101), list.pop());
    }

    @Test
    public void IndexAddingTest() throws ElementAlreadyAddedException, NullElementException {
        List<Integer> list = new List<>();
        list.add(0);
        list.add(1, 0);
        list.add(2, 0);
        list.add(3, 2);
        assertEquals(Integer.valueOf(0), list.pop());
        assertEquals(Integer.valueOf(2), list.pop());
        assertEquals(Integer.valueOf(1), list.pop());
        assertEquals(Integer.valueOf(3), list.pop());
    }

    @Test
    public void popTest() throws ElementAlreadyAddedException, NullElementException {
        List<Integer> list = new List<>();
        list.add(1);
        list.add(2);
        assertEquals(Integer.valueOf(2), list.pop());
        assertEquals(Integer.valueOf(1), list.pop());
    }
	
	@Test
    public void removeTest() throws ElementAlreadyAddedException, NullElementException {
        List<Integer> list = new List<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(Integer.valueOf(2), list.remove(1));
        assertEquals(Integer.valueOf(3), list.remove(0));
        assertEquals(Integer.valueOf(1), list.pop());
    }

    @Test(expected = NullElementException.class)
    public void popExceptionTest() throws ElementAlreadyAddedException, NullElementException {
        List<Integer> list = new List<>();
        list.pop();
        list.add(11);
        list.pop();
        list.pop();
    }

    @Test(expected = NullElementException.class)
    public void removeExceptionTest() throws ElementAlreadyAddedException, NullElementException {
        List<Integer> list = new List<>();
        list.remove(3);
    }
	
    @Test(expected = IndexOutOfBoundsException.class)
    public void IndexAddingExceptionTest() throws ElementAlreadyAddedException {
        List<String> list = new List<>();
        list.add("shdlasdck", 3);
    }
	
	@Test
    public void isEmptyTest() throws ElementAlreadyAddedException, NullElementException {
        List<Integer> list = new List<>();
        assertTrue(list.isEmpty());
        list.add(1111);
        assertFalse(list.isEmpty());
        list.pop();
        assertTrue(list.isEmpty());
    }

    @Test
    public void getLengthTest() throws ElementAlreadyAddedException, NullElementException {
        List<Integer> list = new List<>();
        list.add(13);
        assertEquals(1, list.getLength());
        list.pop();
        assertEquals(0, list.getLength());
        list.add(1);
        list.add(2);
        assertEquals(2, list.getLength());
    }
	
    @Test
    public void findTest() throws ElementAlreadyAddedException {
        List<String> list = new List<>();
        list.add("abcd");
        list.add("qwr");
        assertEquals(0, list.find("qwr"));
        assertEquals(1, list.find("abcd"));
        assertEquals(-1, list.find("tdfkvj"));
    }
}