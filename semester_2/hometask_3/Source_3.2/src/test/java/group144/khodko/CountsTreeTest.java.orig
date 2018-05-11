package group144.khodko;

        import org.junit.Test;

        import java.io.ByteArrayOutputStream;
        import java.io.PrintStream;
        import java.util.Scanner;

        import static org.junit.Assert.*;

public class CountsTreeTest {

    @Test
    public void countTest() {
        CountsTree tree = new CountsTree(new Scanner("(+ 3 (* 12 (/ 6 3)))"));
        assertEquals(27, tree.count());
    }

    @Test
    public void onlyAnswerTest() {
        CountsTree tree = new CountsTree(new Scanner("2"));
        assertEquals(2, tree.count());
    }

    @Test
    public void printTest() {
        CountsTree tree = new CountsTree(new Scanner("(+ 3 (* 12 (/ 6 3)))"));
        String EXPECTED = "(+ 3 (* 12 (/ 6 3)))";

        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        tree.print(new PrintStream(arrayOutputStream));

        assertEquals(EXPECTED, arrayOutputStream.toString());
    }
}
