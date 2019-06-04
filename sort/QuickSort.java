package sort;

public class QuickSort extends SortStrategy{
	
	@Override
	public void sort(Comparable[] array) {
		quickSort(array, 0, array.length - 1);
	}
	
	private void quickSort(Comparable[] array, int firstIndex, int lastIndex) {
		if(firstIndex > lastIndex)
			return;
		int pivotIndex = partition(array, firstIndex, lastIndex);
		quickSort(array, firstIndex, pivotIndex - 1);
		quickSort(array, pivotIndex + 1, lastIndex);
	}
	
	private int partition(Comparable[] array, int firstIndex, int lastIndex) {
		int pivotIndex = firstIndex;
		Comparable pivot = array[firstIndex];
		for(int i = firstIndex + 1; i <= lastIndex; i++) {
			if(array[i].compareTo(pivot) < 0) {
				swap(array, pivotIndex + 1, i);
				pivotIndex++;
			}
		}
		
		swap(array, firstIndex , pivotIndex);
		return pivotIndex;
	}
	
}
