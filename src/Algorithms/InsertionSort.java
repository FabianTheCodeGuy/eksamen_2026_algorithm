package Algorithms;

import FileHandler.Wine;
import java.util.List;

public class InsertionSort {

    public long insertionSort(List<Wine> wines) {
        long ops = 0;

        for (int i = 1; i < wines.size(); i++) {
            Wine key = wines.get(i);
            int j = i - 1;
            ops++;

            while (j >= 0 && wines.get(j).getAlcohol() > key.getAlcohol()) {
                wines.set(j + 1, wines.get(j));
                j--;
                ops++;
            }
            wines.set(j + 1, key);
        }
        return ops;
    }

    public void printFirst(List<Wine> wines, int n) {
        for (int i = 0; i < Math.min(wines.size(), n); i++) {
            System.out.printf("%s - %.2f%n", wines.get(i).getType(), wines.get(i).getAlcohol());
        }
    }
}
