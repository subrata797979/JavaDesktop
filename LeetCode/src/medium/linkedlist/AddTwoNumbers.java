package medium.linkedlist;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AddTwoNumbers {
	
	public static void main(String[] args) {
		List<Integer> l1 = new LinkedList<>(Arrays.asList(2,4,3));
		List<Integer> l2 = new LinkedList<>(Arrays.asList(5,6,4));
		l1.forEach(System.out::println);
		addTwoNumbers(l1,l2).forEach(System.out::println);
	}
	
	public static List<Integer> addTwoNumbers(List<Integer> l1, List<Integer> l2) {
		int i=0, j=0;
		int number1=0, number2=0;
		while(!l1.isEmpty()) {
			number1 += (int)l1.get(i)+i*Math.pow(10,i);
		}
		while(!l2.isEmpty()) {
			number2 += (int)l2.get(j)+j*Math.pow(10,i);
		}
		int number3 = number1+number2;
		List<Integer> l3 = new LinkedList<>();
		
		int use = l1.size()>l2.size()?i:j;
		while(number3!=0) {
			int r = (int) (number3%(use)*Math.pow(10, i));
			number3 = (int) (number3/(use)*Math.pow(10, i));
			l3.add(r);
			use--;
		}
		return l3;
    }
}
