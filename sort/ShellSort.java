package sort;

public class ShellSort extends SortStrategy{

	public void sort(Comparable[] array) {
		for(int gap = array.length; gap > 0; gap/=3) {
			for(int i = gap; i < array.length; i+= 1) {
				for(int j = i; j >= gap && array[j-gap].compareTo(array[j]) > 0; j -= gap) {
					swap(array, j, j - gap);
				}
			}
		}
	}
	
}
