package week1.day4;

public class Palindrome {

	public static void main(String[] args) {
		int num=134431;
		int originalnum=num;
		int reversenum=0;
		while(num!=0)
		{
			int lastdigit=num%10;
			reversenum=reversenum*10+lastdigit;
			num=num/10;
		}
		if(originalnum==reversenum)
		{
			System.out.println("The entered number "+originalnum+ " is paindrome");
		}
		else
		{
			System.out.println("The entered number "+originalnum+ " is not paindrome");
		}
			
	}

}
