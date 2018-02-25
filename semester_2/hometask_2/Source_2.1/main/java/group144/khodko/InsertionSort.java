package group144.khodko;

public class InsertionSort implements Sorter {
    @Override
    public void sort(int[] arr) {
       for (int i = 0; i < arr.length; ++i) {
           int j = i;
           while (j > 0 && arr[j] < arr[j - 1]) {
               int temp = arr[j];
               arr[j] = arr[j - 1];
               arr[j - 1] = temp;
               j--;
           }
       }
    }
}
