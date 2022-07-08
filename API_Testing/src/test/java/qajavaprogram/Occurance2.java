package qajavaprogram;

import java.util.HashMap;

public class Occurance2 {
	
	public static void main(String[] args) {
	
		String str="abcabcabc";
		
		int count1=0;
		
		int ascii=122;
		
		HashMap<Character, Integer> mp= new HashMap<Character, Integer>();
		
		for(int i=0;i<str.length();i++) {
			char c=str.charAt(i);
			String ch=""+c;
			String s1=str.replace(ch, "");
			int count = str.length()-s1.length();
			if(mp.containsKey(c)) {
			}
			else {
				mp.put(c, count);
				
				if(count1<=count) {
					count1=count;
					System.out.println(c);
					int ascii1=c;
					if(ascii>ascii1) {
					ascii=ascii1;
					System.out.println(ascii);
					}
				}
			  }
			}
		
	System.out.println(mp);
		
	}
	
}
