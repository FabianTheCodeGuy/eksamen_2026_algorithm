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

        //hjelpefunkjson fra readfiles som shuffler listen
        List<Wine> shuffledListOne = new ArrayList<>(wines);
        readFiles.shuffleWines(shuffledListOne);
        List<Wine> shuffledListTwo = new ArrayList<>(wines);
        readFiles.shuffleWines(shuffledListTwo);
        List<Wine> shuffledListFour = new ArrayList<>(wines);
        readFiles.shuffleWines(shuffledListFour);

        //sjekk for å se at listene blir shufflet
        System.out.println(shuffledListFour.subList(0,10));
        System.out.println(listFour.subList(0,10));

        System.out.println("==========\nnon-shuffled lists\n");
        bubbleSort.bubbleSort(listOne);
        bubbleSort.bubbleSortOptimised(listTwo);
        System.out.println("==========\nShuffled lists\n");
        bubbleSort.bubbleSort(shuffledListOne);
        bubbleSort.bubbleSortOptimised(shuffledListTwo);

        insertionSort.insertionSort(listThree);
        mergeSort.mergeSort(listFour);
        mergeSort.mergeSort(shuffledListFour);
    }
}