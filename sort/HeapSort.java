package sort;

public class HeapSort extends SortStrategy{

	public void sort(Comparable[] array) {
		
		//Create minHeap
		for(int i = array.length/2 - 1; i >= 0; i--) {
			heapify(array, array.length, i);
		}
		
		//Sort minHeap
		for(int i = array.length - 1; i >= 0; i--) {
			swap(array, 0, i);
			heapify(array, i, 0);
			
		}
	}
	
	private void heapify(Comparable[] array, int size, int index) {
		
		int indexOfLargest = index;
		int leftChildIndex = index * 2 + 1;
		int rightChildIndex = index * 2 + 2;
		boolean hasLeftChild = size > leftChildIndex;
		boolean hasRightChild = size > rightChildIndex;
		
		if(hasLeftChild && array[indexOfLargest].compareTo(array[leftChildIndex]) < 0) {
			indexOfLargest = leftChildIndex;
		}
		if(hasRightChild && array[indexOfLargest].compareTo(array[rightChildIndex]) < 0) {
			indexOfLargest = rightChildIndex;
		}
		if(indexOfLargest != index) {
			swap(array, index, indexOfLargest);
			heapify(array, size, indexOfLargest);
		}
		
	}
}
