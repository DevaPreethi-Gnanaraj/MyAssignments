package week1.day4;

public class StringReverse {

	public static void main(String[] args) {
		String companyName="Testleaf";
		int length= companyName.length();
		System.out.println("String Length is"+length);
		System.out.println("Reveresd string:");
		for(int i=companyName.length()-1;i>=0;i--)
		{
			char charAt = companyName.charAt(i);
			System.out.print(charAt);
		}

	}

}
