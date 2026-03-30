import Algorithms.BubbleSort;
import Algorithms.InsertionSort;
import Algorithms.MergeSort;
import FileHandler.ReadFiles;
import FileHandler.Wine;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReadFiles readFiles = new ReadFiles();
        BubbleSort bubbleSort = new BubbleSort();
        InsertionSort insertionSort = new InsertionSort();
        MergeSort mergeSort = new MergeSort();

        List<Wine> wines = readFiles.readFiles();

        List<Wine> listOne = new ArrayList<>(wines);
        List<Wine> listTwo = new ArrayList<>(wines);
        List<Wine> listThree = new ArrayList<>(wines);
        List<Wine> listFour = new ArrayList<>(wines);

        List<Wine> mergeSorted = mergeSort.mergeSort(listFour);

        bubbleSort.bubbleSort(listOne);
        bubbleSort.bubbleSortOptimised(listTwo);
        insertionSort.insertionSort(listThree);

        System.out.println("\nMerge Sort (first 10 sorted):\n");
        for (int i = 0; i < 10; i++) {
            System.out.println(mergeSorted.get(i).getType() + " - alcohol: " + mergeSorted.get(i).getAlcohol() + " - quality: " + mergeSorted.get(i).getQuality());
        }
    }
}