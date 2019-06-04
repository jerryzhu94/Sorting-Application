package sort;

public class MergeSort extends SortStrategy{
	
	@Override
	public void sort(Comparable[] array) {
		mergeSort(array, 0, array.length - 1);
	}
	
	private void mergeSort(Comparable[] array, int firstIndex, int lastIndex) {
		if(firstIndex == lastIndex)
			return;
		
		int middleIndex = (firstIndex + lastIndex) / 2;
		mergeSort(array, firstIndex, middleIndex);
		mergeSort(array, middleIndex + 1, lastIndex);
		merge(array, firstIndex, lastIndex);
	}
	
	private void merge(Comparable[] array, int firstIndex, int lastIndex) {
		
		Comparable[] temp = new Comparable[array.length];
		int middleIndex = (firstIndex + lastIndex) / 2;
		int first1 = firstIndex;
		int last1 = middleIndex;
		int first2 = middleIndex + 1;
		int last2 = lastIndex;
		for(int i = firstIndex; i <= lastIndex; i++) {
			if(first1 > last1){
				temp[i] = array[first2];
				first2++;
			}else if(first2 > last2) {
				temp[i] = array[first1];
				first1++;
			}else {
				if(array[first1].compareTo(array[first2]) <= 0) {
					temp[i] = array[first1];
					first1++;
				}else {
					temp[i] = array[first2];
					first2++;
				}
			}
		}
		
		for(int i = firstIndex; i <= lastIndex; i++) {
			array[i] = temp[i];
		}
	}
}
