package practice;

import java.util.Scanner;

public class Sum_series4 {
	static int fact(int n)
	{
		int f=1;
		for(int i=1;i<=n;i++)
		{
			f=f*i;
		}
		return f;
	}
	public static void main(String[] args)
	 {
		 Scanner sc=new Scanner(System.in);
			System.out.println("enter a number");
			int n=sc.nextInt();
			double s=0;
			for(int i=1;i<=n;i++)
			{
				s=s+(1/(double)(fact(i)));
			}
			System.out.println("Sum of 1 by factorial of a number :"+s);
	 }
}
