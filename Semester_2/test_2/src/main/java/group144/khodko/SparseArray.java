package group144.khodko;

import java.util.HashMap;
import java.util.Scanner;

public class SparseArray {
    private HashMap<Integer, Integer> hashMap = new HashMap<>();

    public void input(Scanner in){
        int i = 1;
        while (in.hasNextInt()){
            hashMap.put(i, in.nextInt());
            i++;
        }
    }

    public void addition(SparseArray term) {
        term.hashMap.forEach((key, value)->this.add(key, value));
    }

    public void subtraction(SparseArray subtrahend) {
        subtrahend.hashMap.forEach((key, value)->this.add(key, -value));
    }

    private void add(Integer key, Integer value){
        Integer term = hashMap.get(key);
        hashMap.put(key, term + value);
    }

    public Integer dotProduct(SparseArray factor) {
        final int[] result = {0};
        factor.hashMap.forEach((key, value)->result[0] += dotAddition(key, value));
        return result[0];
    }

    private Integer dotAddition(int key, int value) {
        return hashMap.get(key) * value;
    }

    public void clone(SparseArray vector){
        hashMap = vector.hashMap;
    }

    public String print(){
        final String[] result = {""};
        hashMap.forEach((key, value)->result[0] += (Integer.toString(value) + " "));
        return result[0];
    }
}
