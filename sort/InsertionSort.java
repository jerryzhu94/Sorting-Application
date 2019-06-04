package sort;

public class InsertionSort extends SortStrategy{
	
	public InsertionSort() { }
	
	@Override
	public void sort(Comparable[] array){
		for(int i = 0; i < array.length; i++) {
			for(int j = i; j > 0; j--) {
				if(array[j-1].compareTo(array[j]) > 0)
					swap(array, j-1, j);
			}
		}
	}
}
