package group144.khodko;

import org.junit.Test;

import static org.junit.Assert.*;

public class UniqueListTest {

    @Test
    public void addTest() throws ElementAlreadyAddedException, NullElementException {
        UniqueList<Integer> list = new UniqueList<>();
        list.add(0);
        list.add(1);
        assertEquals(Integer.valueOf(2), list.pop());
    }

    @Test
    public void indexAddindTest() throws ElementAlreadyAddedException, NullElementException {
        UniqueList<String> list = new UniqueList<>();
        list.add("abc");
        list.add("sfdsfd", 0);
        assertEquals("abc", list.pop());
    }
	
    @Test(expected = ElementAlreadyAddedException.class)
    public void addToHeadExceptionTest() throws ElementAlreadyAddedException {
        UniqueList<Integer> list = new UniqueList<>();
        list.add(0);
        list.add(0);
    }

    @Test(expected = ElementAlreadyAddedException.class)
    public void indexAddindExceptionTest() throws ElementAlreadyAddedException {
        UniqueList<String> list = new UniqueList<>();
        list.add("abc");
        list.add("sadfa", 0);
        list.add("abc", 1);
    }
}