package ibm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PacketDecoder {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int xorCode = Integer.parseInt(str.substring(0, 8));
		char[] charArray = str.toCharArray();
		List<Character> clist = new ArrayList<>();
		for(int i = 16; i<charArray.length; i+=8 ) {
			char[] atemp = new char[8];
			for(int j=0; j<8; j++) {
				atemp[j] = charArray[j];
			}
			int xorIntResult = xorCode^(Integer.parseInt(atemp.toString()));
			clist.add((char)xorIntResult);
		}
		clist.stream().forEach(System.out::println);
		sc.close();
	}

}
