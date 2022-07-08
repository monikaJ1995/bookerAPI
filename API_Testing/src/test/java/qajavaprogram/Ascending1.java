package qajavaprogram;

public class Ascending1 {


	public static void main(String [] args)
	{
	    String str = "Sanket@123";
        int N = str.length();
	    int [] freq = new int [256];
	    
	    for(int i = 0; i < 512; i++){
	        freq[i] = 0;
	    }

        for (int i = 0; i < N; i++) {
	         char character = str.charAt(i);
	         int val = (int) character;
	         freq[val]++; }
	    
	    for (int i = 0; i < 512; i++) {
	        for (int j = 0; j < freq[i]; j++)
	          
	        System.out.print((char)i);
	    }
	}
}
	 
	

