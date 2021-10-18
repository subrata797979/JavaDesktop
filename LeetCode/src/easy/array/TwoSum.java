package easy.array;

import java.util.Scanner;

public class TwoSum {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
		int n = 4; //to be commented
		int[] arr = new int[n];
		arr[0] = 2;
		arr[1] = 7;
		arr[2] = 11;
		arr[3] = 15;
//		for(int i=0; i<arr.length; i++) {
//			arr[i] = sc.nextInt();
//		}
		
		for(int i:arr) {
			System.out.println(i + " ");
		}
		int target = 9;
		int[] res = twoSum(arr,target);
		System.out.println("Printing Results : ");
		for(int i:res) {
			System.out.println(i);
		}
		sc.close();
	}

	public static int[] twoSum(int[] nums, int target) {
		int[] results = new int[2];
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i]+nums[j]==target) {
                	results[0] = i;
                	results[1] = j;
                	return results;
                }
            }
        }
		return results;
    }
}


//Runtime: 48 ms, faster than 33.12% of Java online submissions for Two Sum.
//Memory Usage: 39.2 MB, less than 61.76% of Java online submissions for Two Sum.

//Optimize Solution - not done
