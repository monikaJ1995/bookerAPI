package qajavaprogram;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortUsingAscci {
	
	public HashMap<Character, Integer> findDuplicates(String str) {
		
		HashMap<Character, Integer> mp= new HashMap<Character, Integer>();
		
		for(int i=0;i<str.length();i++) {//Maharashtra
			
			char c=str.charAt(i); //m //a  //h//a      
			
			if(mp.containsKey(c)) {
				
				mp.put(c, mp.get(c)+1);//a==2
				}
			
			else {//m/a/h ==> key value==>1 /1/1
		
				mp.put(c, 1);
			     }                      }
		System.out.println(mp);
		return mp;
		
	}
	

		
public String removeDuplicates(HashMap<Character, Integer> Map) {
	String str="";
	
	for (Map.Entry<Character, Integer> entry : Map.entrySet()) {
		
		Character key = entry.getKey();
		str=str+key;
		
}
	System.out.println(str);
	return str;	
}


public void sortByAscii(String str) {
	
	char[] arr = str.toCharArray();
	Arrays.sort(arr);
	System.out.println(arr);
	
}
	public static void main(String[] args) {
		
	SortUsingAscci obj= new SortUsingAscci();
	
	HashMap<Character, Integer> Map = obj.findDuplicates("Maharashtra@123");
	
	String str = obj.removeDuplicates(Map);
	
	obj.sortByAscii(str);
	}
}
