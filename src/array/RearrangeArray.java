package array;

public class RearrangeArray {

//	  Rearrange an array such that arr[i] = i 
//	  Input : arr = {-1, -1, 6, 1, 9, 3,2,-1, 4, -1} 
//	  Output : [-1, 1, 2, 3, 4, -1, 6, -1, -1, 9]

	private static void rearrangeArray(int[] arr) {
		printArray(arr);
		int[] temp = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				temp[i] = -1;
				if (i == arr[j]) {
					temp[i] = arr[j];
					break;
				}
			}
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
		rearrangeArray(arr);
	}
}
