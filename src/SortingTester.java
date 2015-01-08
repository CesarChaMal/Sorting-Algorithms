//import java.io.FileWriter;
//import java.io.IOException;
import java.util.*;
public class SortingTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		int[] num = new int[10000];
		for (int i = 0; i < 10000; i++) {
			num[i] = r.nextInt(10000);
		}
		/*for (int i = 0; i < 100; i++) {
			System.out.println(num[i]);
		}
		try {
			FileWriter writer = new FileWriter("input array.txt");
			for (int i = 0; i < 10000; i++) {
				writer.append(num[i] + "\n");
			}
			writer.flush();
			writer.close();
		}
		catch (IOException er) {
			er.printStackTrace();
		}*/
		
		
		//int[] num = {4, 7, 9, 5, 2, 8, 3, 1};
		//int[] num = {2, 5, 3, 13, 12, 4, 1, 3, 2, 9, 8, 7, 6, 12};
		//int[] num = {1, 13, 2, 4};
		int[] numBucket = num;
		final long bucketSortStartTime = System.nanoTime();
		Sorting.bucketSortListNode(numBucket);
		System.out.println("Bucket Sort running time: " + ((System.nanoTime() - bucketSortStartTime)/1000) + "ms");
		
		int[] numCounting = num;
		final long countingSortStartTime = System.nanoTime();
		int[] rst = Sorting.countingSort(numCounting);
		System.out.println("Counting Sort running time: " + ((System.nanoTime() - countingSortStartTime)/1000) + "ms");
		
		int[] numBubble = num;
		final long bubbleSortStartTime = System.nanoTime();
		Sorting.bubbleSort(numBubble);
		System.out.println("Bubble Sort running time: " + ((System.nanoTime() - bubbleSortStartTime)/1000) + "ms");
		
		/*int[] numSelection = num;
		final long selectionSortStartTime = System.nanoTime();
		Sorting.selectionSort(numSelection);
		System.out.println("Selection Sort running time: " + ((System.nanoTime() - selectionSortStartTime)/1000) + "ms");*/
		
		int[] numInsertion = num;
		final long insertionSortStartTime = System.nanoTime();
		Sorting.insertionSort(numInsertion);
		System.out.println("Insertion Sort running time: " + ((System.nanoTime() - insertionSortStartTime)/1000) + "ms");
		
		int[] numMerge = num;
		final long mergeSortStartTime = System.nanoTime();
		Sorting .mergeSort(numMerge);
		System.out.println("Merge Sort running time: " + ((System.nanoTime() - mergeSortStartTime)/1000) + "ms");
		
		int[] numQuick = num;
		final long quickSortStartTime = System.nanoTime();
		Sorting.quickSort(numQuick);
		System.out.println("Quick Sort running time: " + ((System.nanoTime() - quickSortStartTime)/1000) + "ms");
		
		int[] numHeap = num;
		final long heapSortStartTime = System.nanoTime();
		Sorting.heapSort(numHeap);
		System.out.println("Heap Sort running time: " + ((System.nanoTime() - heapSortStartTime)/1000) + "ms");
		
		int[] numDualPivotQuickSort = num;
		final long dualPivotQuickSortStartTime = System.nanoTime();
		Sorting.dualPivotQuickSort(numDualPivotQuickSort);
		System.out.println("Dual Pivot Quick Sort running time: " + ((System.nanoTime() - dualPivotQuickSortStartTime)/1000) + "ms");
		
		int[] numJava = num;
		final long javaSortStartTime = System.nanoTime();
		Arrays.sort(numJava);
		System.out.println("Java Sort running time: " + ((System.nanoTime() - javaSortStartTime)/1000) + "ms");
		/*for (int i = 0; i < rst.length; i++) {
			System.out.print(rst[i] + " ");
		}*/
		
		/*for (int i = 0; i < num.length; i++) {
			System.out.print(numDualPivotQuickSort[i] + " ");
		}
		System.getProperty("line.separator");*/
		
				
	}

}
