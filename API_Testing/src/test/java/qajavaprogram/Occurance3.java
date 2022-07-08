package qajavaprogram;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Occurance3 {
	
	public HashMap<Character, Integer> occurance(String str) {
		
		HashMap<Character, Integer> mp= new HashMap<Character, Integer>();
		
		for(int i=0;i<str.length();i++) {
			
			char c=str.charAt(i);
			
			if(mp.containsKey(c)) {
				
				mp.put(c, mp.get(c)+1);
				
			}
			
			else {
		
				mp.put(c, 1);
			     }
			                           }
		return mp;
	    }
	
	public int getascii(HashMap<Character, Integer> Map,int value, int ascii) {
		
		for (Map.Entry<Character, Integer> entry : Map.entrySet()) {
			
			Character key = entry.getKey();
			Integer val = entry.getValue();
			
			if(val>=value) {
				
				value=val;
				
				int asc=key;
				
				if(asc<=ascii) {
					
					ascii=asc;
					
					}}}
		return ascii;
	}
	
	
public int getMaximum(HashMap<Character, Integer> Map) {
		int count =0;
		for (Map.Entry<Character, Integer> entry : Map.entrySet()) {
			
			
			Integer val = entry.getValue();
			
			if(val>=count) {
				
				count=val;
				}}
		return count;
	}
		
public String removeDuplicates(HashMap<Character, Integer> Map) {
	String str="";
	for (Map.Entry<Character, Integer> entry : Map.entrySet()) {
		
		Character key = entry.getKey();
		str=str+key;
		
}
	return str;	
}


public void sortByAscii(String str) {
	
	char[] arr = str.toCharArray();
	Arrays.sort(arr);
	System.out.println(arr);
	
}
	public static void main(String[] args) {
		
	Occurance3 o= new Occurance3();
	
	HashMap<Character, Integer> Map = o.occurance("Maharashtra@123");
	
	System.out.println(o.getascii(Map, o.getMaximum(Map), 122));
	
	String str = o.removeDuplicates(Map);
	
	o.sortByAscii(str);
	}


	}


