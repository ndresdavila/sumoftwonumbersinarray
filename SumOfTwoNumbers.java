package paquete;

import java.util.*;

public class SumOfTwoNumbers {
	
	public static int[] createArray() {
		Scanner sc_length = new Scanner(System.in);
		System.out.print("Please enter the length of the array:");
		int array_length = sc_length.nextInt();
		//create array of said length
		int[] array = new int[array_length];
		
		Scanner sc_element = new Scanner(System.in);
		for(int i=0;i<array.length;i++) {
			System.out.print("Please enter the element #" + (i+1) + " :");
			array[i] = sc_element.nextInt();
		}
		sc_length.close();
		sc_element.close();
		return array;
	}
	
	public static void printArray(int[] array) {
		System.out.print("[");
		for(int i=0;i<array.length;i++) {
			if(i==array.length-1)
				System.out.print(array[i]);
			else
				System.out.print(array[i] + ",");
		}
		System.out.println("]");
	}
	
	//O(n) complexity (n: number of elements in array)
	public static boolean checkArray(int[] array, int k) {
		Hashtable<Integer, Integer> hashtable = new Hashtable<>();
		
		//add values in Hashtable: O(n)
		for(int i=0;i<array.length;i++) {
			hashtable.put(array[i], i);
		}
		
		//search for complement (k-array[i] inside array): O(n)
		for(int i=0;i<array.length;i++) {
			int complement = k-array[i];
			if(hashtable.contains(complement))
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		
		Scanner sc_k = new Scanner(System.in);
		System.out.print("Please enter the value for k:");
		int k = sc_k.nextInt();
		
		int[] array = createArray();
 		printArray(array);
		
		System.out.println(checkArray(array,k));
		sc_k.close();
	}

}
