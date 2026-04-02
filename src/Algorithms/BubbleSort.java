package Algorithms;

import FileHandler.Wine;
import java.util.List;

public class BubbleSort {

    public int bubbleSort(List<Wine> wines) {
        int n = wines.size();
        int passCount = 0;

        for (int i = 0; i < n - 1; i++) {
            passCount++;
            for (int j = 0; j < n - 1 - i; j++) {
                if (wines.get(j).getAlcohol() > wines.get(j + 1).getAlcohol()) {
                    Wine temp = wines.get(j);
                    wines.set(j, wines.get(j + 1));
                    wines.set(j + 1, temp);
                }
            }
        }
        return passCount;
    }

    public int bubbleSortOptimised(List<Wine> wines) {
        int n = wines.size();
        int passCount = 0;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            passCount++;
            swapped = false;
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
        return passCount;
    }

    public void printFirst(List<Wine> wines, int n) {
        for (int i = 0; i < Math.min(wines.size(), n); i++) {
            System.out.println(wines.get(i).getType() + " - " + wines.get(i).getAlcohol());
        }
    }
}