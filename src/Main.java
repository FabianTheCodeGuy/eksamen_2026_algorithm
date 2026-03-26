import Algorithms.BubbleSort;
import Algorithms.InsertionSort;
import FileHandler.ReadFiles;
import FileHandler.Wine;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReadFiles readFiles = new ReadFiles();
        BubbleSort bubbleSort = new BubbleSort();
        InsertionSort insertionSort = new InsertionSort();

        List<Wine> wines = readFiles.readFiles();

        List<Wine> listOne = new ArrayList<>(wines);
        List<Wine> listTwo = new ArrayList<>(wines);
        List<Wine> listThree = new ArrayList<>(wines);

        bubbleSort.bubbleSort(listOne);
        bubbleSort.bubbleSortOptimised(listTwo);
        insertionSort.insertionSort(listThree);
    }
}