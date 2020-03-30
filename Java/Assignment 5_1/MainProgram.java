package assignment_4_1;

public class MainProgram {

	public static void main(String[] args) {
		System.out.print("N= ");
		int n = SequenceNumber.input(-1);
		System.out.println(n);
		
		SequenceNumber input= new SequenceNumber(n);
		input.print();
		
		System.out.println("Quick sort");
		Sort sort = new QuickSort();
		sort.Sorts();
		input.print();
		
		System.out.println("Selection Sort");
		sort = new SelectionSort();
		sort.Sorts();
		input.print();
		
		System.out.println("Insertion Sort");
		sort = new InsertionSort();
		sort.Sorts();
		input.print();
	}

}
