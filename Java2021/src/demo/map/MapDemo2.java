package demo.map;

import java.util.HashMap;
import java.util.Map;

public class MapDemo2 {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "Rahul");
		map.forEach( (k,v) -> System.out.println(k+" : "+v) );
	}
}
