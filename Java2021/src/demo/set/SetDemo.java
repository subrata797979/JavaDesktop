package demo.set;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {

	public static void main(String[] args) {
		
		Set<Integer> set = new HashSet<>();
		
		set.add(1);
		set.add(2);
		set.add(2);
		set.add(1);
		
		System.out.println(set.isEmpty());
		set.forEach(System.out::println);
		System.out.println(set.contains(1));
		
		set.clear();
		
		set.forEach(System.out::println);
		System.out.println(set.isEmpty());
	}
}
