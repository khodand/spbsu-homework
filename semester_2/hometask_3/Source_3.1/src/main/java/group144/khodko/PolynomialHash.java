package group144.khodko;

public class PolynomialHash implements HashFunc {
    @Override
    public int hash(String text, int mod) {
        final int primeMultiplier = 79;
        int result = 0;

        result += text.charAt(text.length() - 1);

        int p = primeMultiplier;
        for (int i = text.length() - 2; i >= 0; --i) {
            result = (result + (text.charAt(i) * p) % mod) % mod;
            p *= p;
            p %= mod;
        }

        return result;
    }
}