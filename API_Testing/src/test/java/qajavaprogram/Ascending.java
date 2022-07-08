package qajavaprogram;

import java.util.Arrays;

public class Ascending {
	
public static void main(String[] args) {
	
	String str="S@123sanket";
	Ascending asc= new Ascending();
	asc.ascendingBysort(str);
	asc.ascendingBySwap(str);
}

void ascendingBysort(String str) {
char[] arr = str.toCharArray();
Arrays.sort(arr);
System.out.println(arr);
	
}
void ascendingBySwap(String str) {
	char arr[] = str.toCharArray();
    char temp;
    int i = 0;
    while (i < arr.length) {
        int j = i + 1;
        while (j < arr.length) {
            if (arr[j] < arr[i]) {
                 temp = arr[i];
                 arr[i] = arr[j];
                 arr[j] = temp;
               }
             j += 1;}
             i += 1;}

    System.out.println(arr);
	
}

}
