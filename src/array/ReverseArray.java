package array;

public class ReverseArray {

//	  the task is to reverse the array/string. 
//	  Input : arr[] = {1, 2, 3} 
//	  Output : arr[] = {3, 2, 1}

	private static void reverseArray(int[] arr) {
		printArray(arr);
		int[] temp = new int[arr.length];
		int j = arr.length;
		for (int i : arr) {
			temp[--j] = i;
		}
		printArray(temp);
	}

	private static void printArray(int[] arr) {
		for (int i : arr) {
			System.out.print(i);
			System.out.print(",");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// int[] arr = { -1, -1, 6, 1, 9, 3, 2, -1, 4, -1 };
		int[] arr = { 19, 7, 0, 3, 18, 15, 12, 6, 1, 8, 11, 10, 9, 5, 13, 16, 2, 14, 17, 4 };
		reverseArray(arr);
	}
}
