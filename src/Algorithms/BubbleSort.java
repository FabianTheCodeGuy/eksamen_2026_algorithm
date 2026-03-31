package Algorithms;

import FileHandler.Wine;
import java.util.List;

public class BubbleSort {

    // Ikke-optimisert boblesortering - går gjennom hele listen hver runde
    public List<Wine> bubbleSort(List<Wine> wines) {
        int n = wines.size();
        int bubbleCount = 0;
        for (int i = 0; i < n - 1; i++) {
            bubbleCount++;
            for (int j = 0; j < n - 1; j++) {
                if (wines.get(j).getAlcohol() > wines.get(j + 1).getAlcohol()) {
                    Wine temp = wines.get(j);
                    wines.set(j, wines.get(j + 1));
                    wines.set(j + 1, temp);
                }
            }
        }
        System.out.println("\nnon-optimised BubbleSort (first 10):\n");
        for (int i = 0; i < 10; i++) {
            System.out.println(wines.get(i).getType()
                    + " - alcohol: "
                    + wines.get(i).getAlcohol()
                    + " - quality: "
                    + wines.get(i).getQuality());
        }
        System.out.println("Passes (non-optimized): " + bubbleCount);
        return wines;
    }

    // Optimisert boblesortering - avslutter tidlig hvis listen allerede er sortert
    public List<Wine> bubbleSortOptimised(List<Wine> wines) {
        int n = wines.size();
        int bubbleCount = 0;
        for (int i = 0; i < n - 1; i++) {
            bubbleCount++;
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (wines.get(j).getAlcohol() > wines.get(j + 1).getAlcohol()) {
                    Wine temp = wines.get(j);
                    wines.set(j, wines.get(j + 1));
                    wines.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        System.out.println("\noptimised BubbleSort (first 10):\n");
        for (int i = 0; i < 10 ; i++) {
            System.out.println(wines.get(i).getType()
                    + " - alcohol: "
                    + wines.get(i).getAlcohol()
                    + " - quality: "
                    + wines.get(i).getQuality());
            }
        System.out.println("Passes (optimized): " + bubbleCount);
        return wines;
    }
}
