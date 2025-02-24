package week1.day4;

import java.util.Arrays;

public class PrintDuplicates {

	public static void main(String[] args) {
		int num[] ={2, 5, 7, 7, 5, 9, 2, 3};
		Arrays.sort(num);
		System.out.println("Sorted Array");
		for(int j=0;j<num.length-1;j++)
		{
			System.out.println(num[j]);
		}
		System.out.println("*****************************");
		for(int i=0;i<num.length-1;i++)
		{
			if(num[i]==num[i+1])
			{
				System.out.println(num[i]+" "+"is the duplicate value");
			}
			
		}
		
	}

}
