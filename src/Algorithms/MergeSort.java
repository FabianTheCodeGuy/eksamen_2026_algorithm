package Algorithms;
import FileHandler.Wine;

import java.util.List;
import java.util.ArrayList;

public class MergeSort {
    public List<Wine> mergeSort(List<Wine> wines) {
        if (wines.size() <= 1) {
            return wines; // basistilfellet - en liste med ett element er allerede sortert
        }

        // del listen i to halvdeler
        int mid = wines.size() / 2;
        List<Wine> left = new ArrayList<>(wines.subList(0, mid));
        List<Wine> right = new ArrayList<>(wines.subList(mid, wines.size()));

        // sorter hver halvdel rekursivt
        left = mergeSort(left);
        right = mergeSort(right);

        // slå sammen de to sorterte halvdelene
        return merge(left, right);
    }

    private List<Wine> merge(List<Wine> left, List<Wine> right) {
        List<Wine> result = new ArrayList<>();
        int i = 0, j = 0;

        // sammenlign elementer fra begge lister og legg til den minste
        while (i < left.size() && j < right.size()) {
            if (left.get(i).getAlcohol() <= right.get(j).getAlcohol()) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }

        // legg til resterende elementer
        while (i < left.size()) {
            result.add(left.get(i));
            i++;
        }
        while (j < right.size()) {
            result.add(right.get(j));
            j++;
        }

        return result;
    }
}
