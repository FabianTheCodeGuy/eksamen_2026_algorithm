import Algorithms.BubbleSort;
import Algorithms.InsertionSort;
import Algorithms.MergeSort;
import Algorithms.QuickSort;
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
        QuickSort quickSort = new QuickSort();

        List<Wine> wines = readFiles.readFiles();

        List<Wine> listOne = new ArrayList<>(wines);
        List<Wine> listTwo = new ArrayList<>(wines);
        List<Wine> shuffledListOne = new ArrayList<>(wines);
        readFiles.shuffleWines(shuffledListOne);
        List<Wine> shuffledListTwo = new ArrayList<>(wines);
        readFiles.shuffleWines(shuffledListTwo);

        System.out.println("==================== BUBBLE SORT ====================");
        int passes1 = bubbleSort.bubbleSort(listOne);
        System.out.println("\nNon-Optimized Bubble Sort (first 10 sorted):");
        bubbleSort.printFirst(listOne, 10);
        System.out.println("Passes (non-optimized): " + passes1);

        int passes2 = bubbleSort.bubbleSortOptimised(listTwo);
        System.out.println("\nOptimized Bubble Sort (first 10 sorted):");
        bubbleSort.printFirst(listTwo, 10);
        System.out.println("Passes (optimized): " + passes2);

        int passes1Shuffled = bubbleSort.bubbleSort(shuffledListOne);
        System.out.println("\nNon-Optimized Bubble Sort shuffled (first 10 sorted):");
        bubbleSort.printFirst(shuffledListOne, 10);
        System.out.println("Passes (non-optimized shuffled): " + passes1Shuffled);

        int passes2Shuffled = bubbleSort.bubbleSortOptimised(shuffledListTwo);
        System.out.println("\nOptimized Bubble Sort shuffled (first 10 sorted):");
        bubbleSort.printFirst(shuffledListTwo, 10);
        System.out.println("Passes (optimized shuffled): " + passes2Shuffled);

        List<Wine> listThree = new ArrayList<>(wines);
        List<Wine> shuffledListThree = new ArrayList<>(wines);
        readFiles.shuffleWines(shuffledListThree);

        System.out.println("\n==================== INSERTION SORT ====================");
        long opsOriginal = insertionSort.insertionSort(listThree);
        System.out.println("\nInsertion Sort (first 10 sorted):");
        insertionSort.printFirst(listThree, 10);
        System.out.println("Operations (original): " + opsOriginal);

        long opsShuffled = insertionSort.insertionSort(shuffledListThree);
        System.out.println("\nInsertion Sort shuffled (first 10 sorted):");
        insertionSort.printFirst(shuffledListThree, 10);
        System.out.println("Operations (shuffled): " + opsShuffled);

        List<Wine> listFour = new ArrayList<>(wines);
        List<Wine> shuffledListFour = new ArrayList<>(wines);
        readFiles.shuffleWines(shuffledListFour);

        System.out.println("\n==================== MERGE SORT ====================");
        List<Wine> mergeSorted = mergeSort.mergeSort(listFour);
        System.out.println("\nMerge Sort (first 10 sorted):");
        mergeSort.printFirst(mergeSorted, 10);
        System.out.println("Number of merges: " + mergeSort.getMergeCount());

        List<Wine> mergeSortedShuffled = mergeSort.mergeSort(shuffledListFour);
        System.out.println("\nMerge Sort shuffled (first 10 sorted):");
        mergeSort.printFirst(mergeSortedShuffled, 10);
        System.out.println("Number of merges after shuffle: " + mergeSort.getMergeCount());

        List<Wine> copy5 = new ArrayList<>(wines);
        List<Wine> copy6 = new ArrayList<>(wines);
        List<Wine> copy7 = new ArrayList<>(wines);
        List<Wine> copy8 = new ArrayList<>(wines);

        System.out.println("\n==================== QUICK SORT ====================");
        quickSort.quickSortFirst(copy5);
        System.out.println("Comparisons (first): " + quickSort.getComparisonCount());
        quickSort.quickSortLast(copy6);
        System.out.println("Comparisons (last): " + quickSort.getComparisonCount());
        quickSort.quickSortRandom(copy7);
        System.out.println("Comparisons (random): " + quickSort.getComparisonCount());
        quickSort.quickSortMedian(copy8);
        System.out.println("Comparisons (median): " + quickSort.getComparisonCount());
    }
}