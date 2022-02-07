package array;

public class ArrayRotation {

	
	//Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements. 
	private static void rotate(int[] arr, int rotatingIndex, int arraySize) {
		if (rotatingIndex >= arraySize)
			System.out.println("Rotating Index must be less than to Array Size");
		else {
			// Printing the array elements
			printArray(arr);
			int[] temp = new int[arraySize];
			int j = arraySize;
			for (int i = 0; i < arraySize; i++) {

				if (rotatingIndex < arraySize)
					temp[i] = arr[rotatingIndex++];
				else
					temp[i] = arr[arraySize - j--];
			}
			printArray(temp);
		}
	}
	
	private static void printArray( int[] arr) {
		for (int i : arr) {
			System.out.print(i);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };

		rotate(arr, 3, arr.length);
	}
}
