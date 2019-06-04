package sort;

public class BubbleSort extends SortStrategy{
	
	public BubbleSort() { }
	
	@Override
	public void sort(Comparable[] array){
		for(int i = 0; i < array.length; i++) {
			for(int j = array.length - 1; j > i; j --) {
				if(array[j-1].compareTo(array[j]) > 0)
					swap(array, j-1, j);
			}
		}
	}
	
}
