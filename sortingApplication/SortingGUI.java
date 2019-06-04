/* SortingGUI defines the graphic user interface. It has a reference to an IntegerArray object to allow
 * the user to create the array, sort the array, get the runtime of the sorting algorithm, and write 
 * the array to a text file.
 */

package sortingApplication;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

import sort.*;

public class SortingGUI {
	
	//Constructor
	public SortingGUI() {
		initialize();
		defineComponentBehavior();
	}
	
	//Add components to frame
	private void initialize() {
		panelMain.setLayout(new GridLayout(4,2));
		panelMain.add(sizeLabel);
		panelMain.add(sizeText);
		panelMain.add(randomRadioButton);
		panelMain.add(sortedRadioButton);
		panelMain.add(sortingStrategyComboBox);
		panelMain.add(sortButton);
		panelMain.add(runtimeLabel);
		panelMain.add(runtimeText);
		
		radioButtonGroup.add(randomRadioButton);
		radioButtonGroup.add(sortedRadioButton);
		
		frame.add(panelMain);
		frame.setPreferredSize(new Dimension(500, 500));
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
	//Defines the component behavior
	private void defineComponentBehavior() {
		
		//If the sort button gets clicked, select the sorting algorithm from the combo box, sort the array, 
		//and overwrite the text file
		sortButton.addActionListener(new ActionListener () {
			
			@Override
			//Sets the sorting strategy and then sort
			public void actionPerformed(ActionEvent e) {
				
				if(integerArray == null) {
					sizeText.setText("Enter an integer and select a radio button");
					return;
				}
				
				switch((String)sortingStrategyComboBox.getSelectedItem()) {
					case "Selection Sort": 
						integerArray.setStrategy(new SelectionSort());
						break;
					case "Insertion Sort":
						integerArray.setStrategy(new InsertionSort());
						break;
					case "Shell Sort":
						integerArray.setStrategy(new ShellSort());
						break;
					case "Bubble Sort":
						integerArray.setStrategy(new BubbleSort());
						break;
					case "Merge Sort":
						integerArray.setStrategy(new MergeSort());
						break;
					case "Quick Sort":
						integerArray.setStrategy(new QuickSort());
						break;
					case "Heap Sort":
						integerArray.setStrategy(new HeapSort());
						break;
				}
				integerArray.sort();
				runtimeText.setText(integerArray.getRuntime() + " nanoseconds");
				try {
					integerArray.writeToFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		//If the random radio button gets clicked, create an integerArray and write it to a text file
		randomRadioButton.addActionListener(new ActionListener () {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					integerArray = new IntegerArray(Integer.parseInt(sizeText.getText()));
				} catch(NumberFormatException e1){
					sizeText.setText("Enter an integer");
					radioButtonGroup.clearSelection();
					return;
				}
				
				try {
					integerArray.writeToFile();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		});
		
		//If the sorted radio button gets clicked, create an integerArray, sort it, and write it to a text file
		sortedRadioButton.addActionListener(new ActionListener () {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					integerArray = new IntegerArray(Integer.parseInt(sizeText.getText()));
				} catch(NumberFormatException e1){
					sizeText.setText("Enter an integer");
					radioButtonGroup.clearSelection();
					return;
				}
				
				integerArray.setStrategy(new SelectionSort());
				integerArray.sort();
				
				try {
					integerArray.writeToFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	//Private fields
	private IntegerArray integerArray;
	private JFrame frame = new JFrame("Number Converter");
	private JPanel panelMain = new JPanel(new BorderLayout());
	private JLabel sizeLabel = new JLabel("Data Size");
	private JLabel runtimeLabel = new JLabel("Sorting Runtime");
	private JTextField sizeText = new JTextField(20);
	private JTextField runtimeText = new JTextField(20);
	private JButton sortButton = new JButton("Sort");
	private JRadioButton randomRadioButton = new JRadioButton("Random");
	private JRadioButton sortedRadioButton = new JRadioButton("Sorted");
	private ButtonGroup radioButtonGroup = new ButtonGroup();
	private JComboBox sortingStrategyComboBox = new JComboBox(new String[]{
			"Selection Sort" , "Insertion Sort" , "Shell Sort" , "Bubble Sort", "Merge Sort", "Quick Sort", "Heap Sort" });
	
}
