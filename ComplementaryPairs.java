package com.cit.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ComplementaryPairs {

	public static void main(String[] args) {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.print("Enter your k complementary pairs number please:");
			String inputKComplementaryPairs = br.readLine();
	        int k = Integer.parseInt(inputKComplementaryPairs);
			System.out.print("Enter the list of integers separeted by blank space please:");
			String inputIntNumbers = br.readLine();
			String[] arr = inputIntNumbers.split("\\s+");
			int[] intArray = new int[arr.length];
			for (int i = 0; i < arr.length; i++) {
				intArray[i] = Integer.parseInt(arr[i]);
			}
			System.out.println(String.valueOf(findKComplementaryPairs(intArray, k)).concat(" complementary pairs found."));
		} catch (Exception e) {
			System.out.print("Sorry we got a error restart and try again. :(");
		}
    }
	
	
	
	
	/**
	 * Find K-complementary pairs in a given array of integers.
	 * Complexity:
	 * O(N) time at the expense of also being O(N) in terms of memory.
	 * Go through the array once, and store in a Map the difference of the wanted sum and the current element mapped to how many times it occured. Effectively, this map remembers how much we're missing for an element at a given index so that the sum can be reached.
	 * Go through the array a second time, and check whether the map contains this element. If it does, then it means that our map contains an element e for which e = sum - arr[i], so it means that we've found a matching pair. And the number of matching pair we found, is the number of times this element appears in the array, which is the value of the map.
	 * @param arr A
	 * @param k
	 * @return
	 */
	public static int findKComplementaryPairs(int arr[], int k) {
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int i = 0; i < arr.length; i++) {
	        map.merge(k - arr[i], 1, Integer::sum);
	    }
	    return Arrays.stream(arr).map(element -> map.getOrDefault(element, 0)).sum();
	}
}
