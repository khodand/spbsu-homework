import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CompressorTest {

    @Test
    public void compress() {
        Compressor compressor = new Compressor();
        String text = "aaaaaaa333  z";
        assertTrue("7 a 3 3 2   1 z ".equals(compressor.compress(text)));
    }

    @Test
    public void decompress() {
        Compressor compressor = new Compressor();
        String text = "aaaaajsjd  aa333  z";
        String compressedText = compressor.compress(text);

        assertTrue(text.equals(compressor.decompress(compressedText)));
    }
}