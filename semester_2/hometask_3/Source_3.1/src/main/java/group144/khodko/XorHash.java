package group144.khodko;

public class XorHash implements HashFunc {
    @Override
    public int hash(String element, int mod) {
        int result = 0;
        for (char current: element.toCharArray()) {
            result = result ^ current;
        }
        return result % mod;
    }
}