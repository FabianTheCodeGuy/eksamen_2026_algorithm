package Algorithms;

import FileHandler.Wine;

import java.util.List;
import java.util.Random;

public class QuickSort {
    // Første element som pivot
    public List<Wine> quickSortFirst(List<Wine> wines) {
        quickSort(wines, 0, wines.size() - 1, "first");
        System.out.println("\nQuick Sort - First element as pivot (first 10 sorted):\n");
        for (int i = 0; i < 10; i++) {
            System.out.println(wines.get(i).getType() + " - alcohol: " + wines.get(i).getAlcohol());
        }
        return wines;
    }

    // Siste element som pivot
    public List<Wine> quickSortLast(List<Wine> wines) {
        quickSort(wines, 0, wines.size() - 1, "last");
        System.out.println("\nQuick Sort - Last element as pivot (first 10 sorted):\n");
        for (int i = 0; i < 10; i++) {
            System.out.println(wines.get(i).getType() + " - alcohol: " + wines.get(i).getAlcohol());
        }
        return wines;
    }

    // Tilfeldig element som pivot
    public List<Wine> quickSortRandom(List<Wine> wines) {
        quickSort(wines, 0, wines.size() - 1, "random");
        System.out.println("\nQuick Sort - Random element as pivot (first 10 sorted):\n");
        for (int i = 0; i < 10; i++) {
            System.out.println(wines.get(i).getType() + " - alcohol: " + wines.get(i).getAlcohol());
        }
        return wines;
    }

    // Median av tre som pivot
    public List<Wine> quickSortMedian(List<Wine> wines) {
        quickSort(wines, 0, wines.size() - 1, "median");
        System.out.println("\nQuick Sort - Median of three as pivot (first 10 sorted):\n");
        for (int i = 0; i < 10; i++) {
            System.out.println(wines.get(i).getType() + " - alcohol: " + wines.get(i).getAlcohol());
        }
        return wines;
    }

    // hovedmetode for quicksort
    private void quickSort(List<Wine> wines, int low, int high, String pivotStrategy) {
        if (low < high) {
            int pivotIndex = partition(wines, low, high, pivotStrategy);
            quickSort(wines, low, pivotIndex - 1, pivotStrategy);
            quickSort(wines, pivotIndex + 1, high, pivotStrategy);
        }
    }

    // velger pivot og partisjonerer listen
    private int partition(List<Wine> wines, int low, int high, String pivotStrategy) {
        // velg pivot basert på strategi
        switch (pivotStrategy) {
            case "first":
                swap(wines, low, high); // flytt første til slutten som pivot
                break;
            case "last":
                break; // siste element er allerede pivot
            case "random":
                int randomIndex = low + new Random().nextInt(high - low + 1);
                swap(wines, randomIndex, high); // flytt tilfeldig til slutten som pivot
                break;
            case "median":
                int mid = low + (high - low) / 2;
                // finn median av første, midtre og siste element
                if (wines.get(low).getAlcohol() > wines.get(mid).getAlcohol()) swap(wines, low, mid);
                if (wines.get(low).getAlcohol() > wines.get(high).getAlcohol()) swap(wines, low, high);
                if (wines.get(mid).getAlcohol() > wines.get(high).getAlcohol()) swap(wines, mid, high);
                swap(wines, mid, high); // flytt median til slutten som pivot
                break;
        }

        double pivotAlcohol = wines.get(high).getAlcohol();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (wines.get(j).getAlcohol() <= pivotAlcohol) {
                i++;
                swap(wines, i, j);
            }
        }
        swap(wines, i + 1, high); // sett pivot på riktig plass
        return i + 1;
    }

    private void swap(List<Wine> wines, int a, int b) {
        Wine temp = wines.get(a);
        wines.set(a, wines.get(b));
        wines.set(b, temp);
    }
}
