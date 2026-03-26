package Algorithms;

import FileHandler.Wine;
import java.util.List;

public class InsertionSort {
    public List<Wine> insertionSort(List<Wine> wines) {
        int n = wines.size();

        for (int i = 1; i < n; i++) {
            Wine key = wines.get(i); // tar ut elementet som skal plasseres
            int j = i - 1;

            // flytter elementer som er større enn key en plass fremover
            while (j >= 0 && wines.get(j).getAlcohol() > key.getAlcohol()) {
                wines.set(j + 1, wines.get(j));
                j--;
            }
            wines.set(j + 1, key); // setter key på riktig plass
        }

        System.out.println("\nInsertion Sort (first 10 sorted):\n");
        for (int i = 0; i < 10; i++) {
            System.out.println(wines.get(i).getType() + " - alcohol: " + wines.get(i).getAlcohol() + " - quality: " + wines.get(i).getQuality());
        }
        return wines;
    }
}
