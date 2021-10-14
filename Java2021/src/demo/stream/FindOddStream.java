package demo.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FindOddStream {
	public static void main(String[] args) {
		System.out.println("Enter the size of the array : ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> list = new ArrayList<>(n);	
		for(int i=0; i<n; i++) {
			list.add(i);
		}
		
		list.stream().forEach(System.out::println); //why we prefer stream over normal list?
		
		//list.forEach(System.out::println);
		System.out.println("List of odd numbers : ");
		
		List<Integer> list2 = list.stream().filter(i->i%2!=0).collect(Collectors.toList());
		
		list2.forEach(i -> System.out.print(i+" "));
		
		
		System.out.println("\nUpto n/2");
		list.stream().filter(i -> i<n/2).forEach(System.out::println);
		
		//Can I input directly as a stream? Is that even useful by any means?
		System.out.println("toList");
		
		//collecting as an array
		list = list.stream().filter(i->i%2==0).toList(); //.toList() vs .collect(Collector.toList())
		list.forEach(i -> System.out.print(i+" "));
		list.stream().filter(i->i%2==0).forEach(System.out::println);
		
		System.out.println("toArray");
		
		//https://howtodoinjava.com/java8/java-streams-by-examples/    (see the toArray example)
		Integer[] arr = list.stream().filter(i->i%2==0).toArray(Integer[]::new); 
		System.out.println(arr);
		for(Integer i=0; i<arr.length; i++) {
			System.out.println("At position " + i + " element : " + arr[i]);
		}
		sc.close();
	}
}
