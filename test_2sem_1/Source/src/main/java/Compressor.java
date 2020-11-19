/**
 * Class for compressing/decompressing text by counting repeats of chars
 */
public class Compressor {

    /**
     * Method for compressing
     * @param text - text to compress
     * @return compressed text
     */
    public String compress(String text) {
       String compressedText = "";
       int i = 0;
       int j = 0;
       while (i < text.length()) {
           j = i;
           while (j < text.length() && text.charAt(i) == text.charAt(j))
               j++;

           compressedText += Integer.toString(j - i) + " " + text.charAt(i) + " ";
           i = j;
       }

       return compressedText;
    }

    /**
     * Method for decompressing
     * @param compressedText - text to decompress
     * @return decompressed text
     */
    public String decompress(String compressedText){
        String text = "";
        int i = 0;
        while(i < compressedText.length()){
            String number = "";
            while (compressedText.charAt(i) != ' ') {
                number += compressedText.charAt(i);
                i++;
            }

            i++;
            int size = Integer.parseInt(number);
            for (int j = 0; j < size; j++)
                text += compressedText.charAt(i);

            i += 2;
        }
        return text;
    }
}
