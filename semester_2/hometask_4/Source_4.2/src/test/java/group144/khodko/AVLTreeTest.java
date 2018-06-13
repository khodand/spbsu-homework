package group144.khodko;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.*;

public class AVLTreeTest {

    private AVLTree<Integer> tree;

    private static ArrayList<Integer> generateList(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(ThreadLocalRandom.current().nextInt());
        }
        return list;
    }

    @Before
    public void setUp() {
        tree = new AVLTree<>();
    }

    @Test
    public void testAdd() {
        tree.add(6);
        tree.add(5);
        tree.add(7);
        assertEquals("(6 left:(5 left: right:) right:(7 left: right:))", tree.printTree());
    }

    @Test
    public void testAddAll() {
        tree.addAll(Arrays.asList(7, 5, 6));
        assertEquals("(6 left:(5 left: right:) right:(7 left: right:))", tree.printTree());
    }

    @Test
    public void testSize() {
        assertEquals(0, tree.size());
        tree.addAll(Arrays.asList(7, 5, 6));
        assertEquals(3, tree.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(tree.isEmpty());
        tree.addAll(Arrays.asList(7, 5, 6));
        assertFalse(tree.isEmpty());
    }

    @Test
    public void testClear() {
        tree.addAll(Arrays.asList(7, 5, 6));
        assertFalse(tree.isEmpty());
        tree.clear();
        assertTrue(tree.isEmpty());
    }

    @Test
    public void testIterator() {
        tree.addAll(Arrays.asList(6, 5, 7));
        Iterator<Integer> iterator = tree.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(5), iterator.next());
        assertEquals(Integer.valueOf(6), iterator.next());
        assertTrue(iterator.hasNext());
        assertTrue(iterator.hasNext());
        assertTrue(iterator.hasNext());
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(7), iterator.next());
        assertFalse(iterator.hasNext());
        assertFalse(iterator.hasNext());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testIteratorSort() {
        List<Integer> list = generateList(10000);
        tree.addAll(list);
        Collections.sort(list);
        List<Integer> treeList = new ArrayList<>(tree);
        assertEquals(list, treeList);
    }

    @Test
    public void testToArray() {
        int n = 10000;
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            int nextInt = ThreadLocalRandom.current().nextInt();
            array[i] = nextInt;
            tree.add(nextInt);
        }
        Arrays.sort(array);
        Object[] treeList = tree.toArray();
        assertArrayEquals(array, treeList);
    }

    @Test
    public void testToArrayObject() {
        int n = 10000;
        Integer[] array = new Integer[n + 10];
        for (int i = 0; i < n; i++) {
            int nextInt = ThreadLocalRandom.current().nextInt();
            array[i] = nextInt;
            tree.add(nextInt);
        }
        Arrays.sort(array, 0, n);
        Integer[] treeArray = new Integer[n + 10];
        assertArrayEquals(tree.toArray(treeArray), array);
    }

    @Test
    public void testRemove() {
        tree.addAll(Arrays.asList(6, 5, 7));
        assertTrue(tree.remove(5));
        assertFalse(tree.remove(5));
        assertTrue(tree.remove(6));
        assertFalse(tree.remove(6));
        assertTrue(tree.remove(7));
        assertFalse(tree.remove(7));
        assertFalse(tree.remove(6));
        assertFalse(tree.remove(5));
    }

    @Test
    public void testRemoveAll() {
        List<Integer> list = generateList(10000);
        tree.addAll(list);
        assertTrue(tree.removeAll(list));
        assertFalse(tree.removeAll(list));
    }

    @Test
    public void testContains() {
        tree.addAll(Arrays.asList(6, 5, 7));
        assertTrue(tree.contains(5));
        assertTrue(tree.contains(6));
        assertTrue(tree.contains(7));
        assertFalse(tree.contains(8));
        assertFalse(tree.contains(9));
        assertFalse(tree.contains(10));
        tree.add(55);
        assertTrue(tree.contains(55));
        tree.remove(7);
        assertFalse(tree.contains(7));
    }

    @Test
    public void testContainsAll() {
        List<Integer> list = generateList(10000);
        tree.addAll(list);
        assertTrue(tree.containsAll(list));
        list.add(5);
        assertFalse(tree.containsAll(list));
    }

    @Test
    public void testRetainAll() {
        List<Integer> list = Arrays.asList(8, 6, 7, 5);
        tree.addAll(list);
        assertFalse(tree.retainAll(list));
        tree.add(2);
        assertTrue(tree.retainAll(list));
        tree.remove(2);
        assertFalse(tree.retainAll(list));
        tree.remove(8);
        assertFalse(tree.retainAll(list));
    }

}