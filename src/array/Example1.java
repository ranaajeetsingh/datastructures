package array;

public class Example1 {
	public static void main(String[] args) {
// declares an array of int
		int[] arr;

		// allocating memory of 5 integers.
		arr = new int[5];

		// initialize the array elements
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}

		// accessing the array elements
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Element at index: " + i + " is " + arr[i]);
		}
	}

}
