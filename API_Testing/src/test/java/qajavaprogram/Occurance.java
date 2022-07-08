package qajavaprogram;


public class Occurance {

public static void main(String[] args) {
		
String str="acababc";

int count1=0;

int ascii=122;

int ascii1=0;

for(int i=0;i<str.length();i++) {

	char c= str.charAt(i);
	
	String s=""+c;
	
	String re=str.replace(s, "");
	
	int count2 =str.length()-re.length();
	
	if(count2>=count1) {
		
		if(count1==count2) {
			
			
			  if((int)c<=ascii) {
	
				  ascii=(int)c;
			  
			  }
			  else {
					  ascii1=(int)(c);
		}
			
		}
		count1=count2;
		
		
	}
	
	str=re;
	System.out.println(str);
	}
	System.out.println(ascii);	
}}
