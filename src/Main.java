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

        List<Wine> shuffledList = new ArrayList<>(wines);
        readFiles.shuffleWines(shuffledList); //hjelpefunkjson fra readfiles som shuffler listen

        System.out.println(shuffledList.subList(0,10));
        System.out.println(listFour.subList(0,10));

        bubbleSort.bubbleSort(listOne);
        bubbleSort.bubbleSortOptimised(listTwo);
        insertionSort.insertionSort(listThree);
        mergeSort.mergeSort(listFour);
        mergeSort.mergeSort(shuffledList);
    }
}