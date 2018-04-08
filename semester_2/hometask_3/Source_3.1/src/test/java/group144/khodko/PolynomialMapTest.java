package group144.khodko;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class PolynomialMapTest {

    @Test
    public void add() {
        HashMap map = new HashMap(141);

        map.add("Bob");
        map.add("Alisa");
        map.add("KappaRoss");

        assertEquals(3, map.numberOfWords());
    }

    @Test
    public void getFrequencyOfWord() {
        HashMap map = new HashMap(141);

        map.add("Bob");
        map.add("Keepo");
        map.add("Keepo");

        assertEquals(1, map.getFrequencyOfWord("Bob"));
        assertEquals(2, map.getFrequencyOfWord("Keepo"));
        assertEquals(0, map.getFrequencyOfWord("Alisa"));
    }

    @Test
    public void outWholeChain() {
        HashMap map = new HashMap(141);

        map.add("Bob");

        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(arrayOutputStream));

        map.outWholeChain("Bob");

        assertEquals("Bob ", arrayOutputStream.toString());
    }

    @Test
    public void numberOfWords() {
        HashMap map = new HashMap(141);

        assertEquals(0, map.numberOfWords());
        map.add("Bob");
        assertEquals(1, map.numberOfWords());

        map.add("Keepo");
        assertEquals(2, map.numberOfWords());
        map.add("Keepo");
        assertEquals(2, map.numberOfWords());

        map.add("Alisa");
        assertEquals(3, map.numberOfWords());
    }

    @Test
    public void resize() {
        HashMap map = new HashMap(3);

        map.add("Bob");
        map.add("Alisa");
        map.getLoadFactor();
        double standard = map.getLoadFactor();

        map.add("KappaRoss");
        map.add("BlessRNG");
        map.add("BibleThump");
        double resized = map.getLoadFactor();

        assert(standard > resized);
    }
}