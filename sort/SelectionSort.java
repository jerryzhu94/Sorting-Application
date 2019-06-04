package sort;

public class SelectionSort extends SortStrategy{
	
	public SelectionSort() { }
	
	@Override
	public void sort(Comparable[] array)
	{
		for(int i = 0; i < array.length; i++) {
			int minIndex = i;
			for(int j = i; j < array.length; j++) {
				if(array[minIndex].compareTo(array[j]) > 0)
					minIndex = j;
			}
			swap(array, minIndex, i);	
		}
	}
}
