package test.java.group144.khodko;

import org.junit.Test;

import java.util.*;

import static  group144.khodko.SecondPartTasks.*;
import static org.junit.Assert.assertEquals;

public class SecondPartTasksTest {

    @Test
    public void testFindQuotes() {
        assertEquals(Arrays.asList("aaaABCaaa", "bbbABCbbb", "cccABCccc"),
                findQuotes(Arrays.asList("aaaABCaaa", "bbbABCbbb", "aaaAAAaaa", "sadfasdsabc", "cccABCccc", "q1axvd"), "ABC"));
    }

    @Test
    public void testPiDividedBy4() {
        assertEquals(3.141 / 4, piDividedBy4(), 0.01);
    }

    @Test
    public void testFindPrinter() {
        Map<String, List<String>> artists = new HashMap<>();
        artists.put("Artist_0", Arrays.asList("abc", "aqw", "awr", "sgg"));
        artists.put("Artist_1", Arrays.asList("ab", "aq", "aw", "sg"));

        assertEquals("Artist_0", findPrinter(artists));

        artists.put("Artist_2", Arrays.asList("ab11", "aq11", "aw11", "sg11"));
        assertEquals("Artist_2", findPrinter(artists));
    }

    @Test
    public void testCalculateGlobalOrder() {
        List<Map<String, Integer>> orders = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            orders.add(new HashMap<>());
        }

        orders.get(0).put("a", 13);

        orders.get(1).put("a", 10);
        orders.get(1).put("b", 22);

        orders.get(2).put("b", 8);
        orders.get(2).put("c", 141);
        
        orders.get(3).put("d", 11);


        Map<String, Integer> result = new HashMap<>();
        result.put("a", 23);
        result.put("b", 30);
        result.put("c", 141);
        result.put("d", 11);

        assertEquals(result, calculateGlobalOrder(orders));
    }
}