package group144.khodko;

/**
 * Hash table class with lists
 */
public class HashMap {
    private List[] hashes;
    private HashFunc hashFunc = new PolynomialHash();

    private int used = 0;
    private int size = 0;

    // Array with all possible sizes of table
    private final int primeArr[] = {141, 4713, 5795, 6611, 18496, 32292, 32469, 59656, 90825,
            262419, 361275, 481899, 1354828, 6328548, 6679881};

    HashMap(int size) {
        hashes = new List[size];
        for (int i = 0; i < size; ++i)
            hashes[i] = new List();
        this.size = size;
    }

    private int newSize() {
        for (int aPrimeArr : primeArr) {
            if (size < aPrimeArr) {
                return aPrimeArr;
            }
        }
        return size * 2 + 1;
    }

    private void resize() {
        HashMap newMap = new HashMap(newSize());

        for (int i = 0; i < size; ++i)
            for (int j = 0; j < hashes[i].numberOfWords(); ++j)
                newMap.add(this.hashes[i].get(j));

        this.hashes = newMap.hashes;
        this.size = newMap.size;
    }

    // Method changes the hash class
    public void changeHashFunc(HashFunc hashFunc) {
        HashMap newMap = new HashMap(size);
        newMap.hashFunc = hashFunc;

        for (int i = 0; i < size; ++i)
            for (int j = 0; j < hashes[i].numberOfWords(); ++j)
                newMap.add(this.hashes[i].get(j));

        this.hashes = newMap.hashes;
        this.hashFunc = hashFunc;
    }

    /**
     * Add func uses list in case of collision
     * uses resize() if the table is overloaded
     */
    public void add(String text) {
        if (size == 0) {
            size = primeArr[0];
            hashes = new List[size];
        }

        used++;

        double loadFactor = (double)used / size;
        if (loadFactor > 1)
            resize();

        hashes[hashFunc.hash(text, size)].add(text);
    }

    public void out() {
        for (int i = 0; i < size; ++i)
            for (int j = 0; j < hashes[i].numberOfWords(); ++j)
                System.out.print(hashes[i].get(j) + ' ');
    }

    /**
     * Stats methods
     */
    public int getFrequencyOfWord(String text) {
        return hashes[hashFunc.hash(text, size)].getFrequencyOfWord(text);
    }

    public double getAverageLen() {
        double sum = 0.0;
        for (int i = 0; i < size; ++i)
            sum += hashes[i].numberOfWords();

        return sum / size;
    }

    public int getMaxLen() {
        int maxLen = 0;
        for (int i = 0; i < size; ++i)
            if (maxLen < hashes[i].numberOfWords())
                maxLen = hashes[i].numberOfWords();

        return maxLen;
    }

    public void outWholeChain(String word) {
        int wordHash = hashFunc.hash(word, size);
        for (int i = 0; i < hashes[wordHash].numberOfWords(); ++i)
            System.out.print(hashes[wordHash].get(i) + ' ');
    }

    public int numberOfWords() {
        int result = 0;
        for (int i = 0; i < size; ++i) {
            result += hashes[i].numberOfWords();
        }
        return result;
    }

    public int numberOfEmptyBuckets() {
        return size - used;
    }

    public double getLoadFactor() {
        return (double)used / size;
    }

}