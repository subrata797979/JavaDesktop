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
		System.out.println();
		map.forEach((k, v) -> System.out.println(k + " " + v));
	}
}


// how to override toString() of map 

//Map<String, String> test = new HashMap<>() {
//    @Override
//    public String toString() {
//        StringBuilder stb = new StringBuilder();
//        for (Map.Entry<String, String> entry : this.entrySet()) {
//            stb.append(entry.getKey()).append(" ")
//                    .append(entry.getValue()).append("\n");
//        }
//        return stb.toString();
//    }
//};    // not working