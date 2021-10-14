package demo.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapDemo {

	public static void main(String[] args) {
		
		Map<String, String> map = new HashMap<>();
		map.put("name", "Subrata");
		map.put("roll", "s001");
		map.put("class", "10");
		
		Set<Entry<String, String>> entries = map.entrySet();
		System.out.println(entries);
		for(Entry<String, String> e : entries) {
			System.out.println("Key : " + e.getKey() + " & Value : " + e.getValue());
		}
		
		map.forEach((k, v) -> System.out.println(k + " " + v));
	}
}
