/* This class is used to generate the array, store the array, sort the array, report the runtime, 
 * and write the array to a text file. This array holds a reference to SortStrategy, an abstract class
 * that provides a polymorphic sort method. This allows the user to choose a sorting algorithm during runtime.
 */

package sortingApplication;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import sort.*;

public class IntegerArray {
	
	//Constructor
	public IntegerArray(int size) {
		this.array = new Comparable[size];
		this.isSorted = false;
		Random rand = new Random();
		for(int i = 0; i < size; i++) {
			array[i] = rand.nextInt(1000); 
		}
	}
	
	//Sets the sorting algorithm that will be used when the sort method get called
	public void setStrategy(SortStrategy strategy) {
		this.strategy = strategy;
	}
	
	//Sorts the array by using the selected sorting algorithm
	public void sort() {
		this.isSorted = true;
		long startTime = System.nanoTime();
		strategy.sort(array);
		this.runtime = System.nanoTime() - startTime;
	}
	
	
	//Returns the runtime of the sorting algorithm
	public long getRuntime() {
		return this.runtime;
	}
	
	//Writes array to text file
	public void writeToFile() throws IOException {
		String fileName = (isSorted) ? String.format("%s%d.txt", "sorted", array.length) : String.format("%s%d.txt", "random", array.length);
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
		for(int i = 0 ; i < array.length; i++) {
			writer.write(array[i].toString() + " ");
		}
		writer.close();
	}
	
	//Private fields
	private boolean isSorted;
	private static Comparable[] array;
	private SortStrategy strategy;
	private long runtime;
}
