package week1.day3;

public class IsPrimeNumber {

	public static void main(String[] args) {
		int flag=0,num =11; // declaring a number and a temp flag 
		for(int i=2;i<num-1;i++)
		{
			if(num%i==0)
			{
				flag=1; //Indicates that the number is divisible by other number hence flag set to 1
				break; // breaks the loop
			}
			else
			{
				flag=0;
			}
		}
		if(flag==0) // using conditional statement
		{
			System.out.println("The Number is prime");
		}
		else {
			System.out.println("The Number is Not prime");
		}

	}
}
