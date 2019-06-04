/* SortStrategy is an abstract class that serves as an interface for the IntegerArray class.
 * It has only one public method: sort. The sort method is polymorphic and will behave 
 * differentlydepending on what concrete sorting algorithm overrides it.
 * InsertionSort, SelectionSort, ShellSort, BubbleSort, MergeSort, QuickSort, and HeapSort extend SortStrategy.
 * The GoF strategy pattern is a behavioral software design pattern that enables selecting an algorithm at runtime.
 */

package sort;

public abstract class SortStrategy {
	
	//Concrete sorting algorithms will implement this method
	public abstract void sort(Comparable[] array);
	
	//Shared method used by concrete sorting algorithms
	protected static void swap(Comparable[] array, int index1, int index2) {
		Comparable temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
}
