package week1.day3;

public class FibonacciSeries {

	public static void main(String[] args) {
		int endnum=8, first=0,second =1;
		for(int i=0; i<endnum;i++)
		{
			int sum =first+second;
			System.out.print(first+ " ");
			first=second;
			second=sum;
		}

	}

}
