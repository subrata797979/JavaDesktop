package demo.list;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
	public static void main(String[] args) {
		List<String> pointList = new ArrayList<>();
		 
		pointList.add("1");
		pointList.add("2");
		 
//		pointList.forEach(p ->  { System.out.println(p); } );
		pointList.forEach(System.out::println); // method reference 
		//jehetu ami consumer use kor6i r eta akta class method reference tai ami eta likhte pari
	}

}
