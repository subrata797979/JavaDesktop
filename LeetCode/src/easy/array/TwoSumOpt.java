package easy.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSumOpt {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = 4; //to be commented
		int[] arr = new int[n];
		arr[0] = 2;
		arr[1] = 7;
		arr[2] = 11;
		arr[3] = 15;
		
		for(int i:arr) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		int target = 9;
		int[] res = twoSum(arr,target);
		System.out.println("Printing Results : ");
		for(int i:res) {
			System.out.println(i);
		}
		sc.close();
		
	}

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> visitedNumbers = new HashMap<>();
		for(int i=0; i<nums.length; i++) {
            int delta = target - nums[i];
            if(visitedNumbers.containsKey(delta)) {
                return new int[] {i, visitedNumbers.get(delta)};
            }
            visitedNumbers.put(nums[i], i);
		}
		return new int[] {-1, -1};
    }

}
