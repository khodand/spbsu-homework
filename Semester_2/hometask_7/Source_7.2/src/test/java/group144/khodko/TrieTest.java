package group144.khodko;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrieTest {

    private Trie root;

    @Test
    public void add() {
        root = new Trie();

        assertTrue(root.add("abc"));
        assertFalse(root.add("abc"));
        assertTrue(root.add("ab"));
        assertTrue(root.add("abd"));
        assertTrue(root.add("a"));
        assertFalse(root.add("a"));
        assertTrue(root.add("b"));
        assertFalse(root.add("a"));
        assertTrue(root.add(""));
        assertFalse(root.add(""));
    }

    @Test
    public void contains() {
        root = new Trie();

        root.add("asd");
        root.add("qqq");
        assertTrue(root.contains("asd"));
        assertFalse(root.contains("rr"));
        assertTrue(root.contains("qqq"));
        root.add("rr");
        assertTrue(root.contains("rr"));
        assertFalse(root.contains(""));
    }

    @Test
    public void size() {
        root = new Trie();

        addAll("aaa", "a", "sdsd");
        assertEquals(3, root.size());
        root.add("qqq");
        assertEquals(4, root.size());
        root.add("");
        assertEquals(5, root.size());
        root.add("");
        assertEquals(5, root.size());
        root.remove("");
        assertEquals(4, root.size());
        root.remove("");
        assertEquals(4, root.size());
        root.remove("a");
        root.remove("aaa");
        assertEquals(2, root.size());
    }

    @Test
    public void remove() {
        root = new Trie();

        assertFalse(root.remove(""));
        addAll("aaa", "abbb", "ab");
        assertFalse(root.remove("a"));
        assertTrue(root.contains("aaa"));
        assertTrue(root.remove("aaa"));
        assertFalse(root.remove("aaa"));
        assertFalse(root.remove("adsdasdasdsdads"));
    }

    @Test
    public void howManyStartWithPrefix() {
        root = new Trie();

        assertEquals(0, root.howManyStartWithPrefix(""));
        assertEquals(0, root.howManyStartWithPrefix("aa"));
        addAll("c", "a", "", "d", "aa", "ac");
        assertEquals(1, root.howManyStartWithPrefix("c"));
        assertEquals(3, root.howManyStartWithPrefix("a"));
        assertEquals(1, root.howManyStartWithPrefix("d"));
        assertEquals(1, root.howManyStartWithPrefix("ac"));
        assertEquals(1, root.howManyStartWithPrefix("aa"));
    }

    private void addAll(String... strings) {
        for (String string : strings) {
            root.add(string);
        }
    }
}