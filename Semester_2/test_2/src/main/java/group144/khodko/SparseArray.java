package group144.khodko;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Class realizing sparse array on hashMap.
 */
public class SparseArray {
    private HashMap<Integer, Integer> hashMap = new HashMap<>();

    /**
     * method for inputing vector by coord
     *
     * @param in our input stream
     */
    public void input(Scanner in){
        int i = 1;
        while (in.hasNextInt()){
            hashMap.put(i, in.nextInt());
            i++;
        }
    }

    /**
     * methods for addition and subtraction by coords
     * @param term vector to add
     */
    public void addition(SparseArray term) {
        term.hashMap.forEach((key, value)->this.add(key, value));
    }

    //@param subtrahend vector to sub
    public void subtraction(SparseArray subtrahend) {
        subtrahend.hashMap.forEach((key, value)->this.add(key, -value));
    }

    // method to simple arifm with value of each coord
    private void add(Integer key, Integer value){
        Integer term = hashMap.get(key);
        hashMap.put(key, term + value);
    }

    // dot product method
    public Integer dotProduct(SparseArray factor) {
        final int[] result = {0};
        factor.hashMap.forEach((key, value)->result[0] += dotMult(key, value));
        return result[0];
    }

    // method to mult by coor for addition (dot product algo)
    private Integer dotMult(int key, int value) {
        return hashMap.get(key) * value;
    }

    // method vector1 = vector2 <=> vector1.clone(vector2)
    public void clone(SparseArray vector){
        hashMap = vector.hashMap;
    }

    public String print(){
        final String[] result = {""};
        hashMap.forEach((key, value)->result[0] += (Integer.toString(value) + " "));
        return result[0];
    }
}
