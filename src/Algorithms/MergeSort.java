package Algorithms;
import FileHandler.Wine;

import java.util.List;
import java.util.ArrayList;

public class MergeSort {
    private int mergeCount = 0;

    public int getMergeCount() {
        return mergeCount;
    }

    public List<Wine> mergeSort(List<Wine> wines) {
        mergeCount = 0; // nullstill teller før hver sortering
        return mergeSortHelper(wines);
    }

    private List<Wine> mergeSortHelper(List<Wine> wines) {
        if (wines.size() <= 1) {
            return wines;
        }

        int mid = wines.size() / 2;
        List<Wine> left = new ArrayList<>(wines.subList(0, mid));
        List<Wine> right = new ArrayList<>(wines.subList(mid, wines.size()));

        left = mergeSortHelper(left);
        right = mergeSortHelper(right);

        return merge(left, right);
    }

    private List<Wine> merge(List<Wine> left, List<Wine> right) {
        mergeCount++;
        List<Wine> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).getAlcohol() <= right.get(j).getAlcohol()) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }

        while (i < left.size()) { result.add(left.get(i)); i++; }
        while (j < right.size()) { result.add(right.get(j)); j++; }

        return result;
    }
}