package practice;

import java.util.Scanner;

public class Sum_series3 {
	public static void main(String[] args)
	 {
		 Scanner sc=new Scanner(System.in);
			System.out.println("enter a number");
			int n=sc.nextInt();
			double s=0;
			for(int i=0;i<n;i++)
			{
				s=s+(1/(double)(Math.pow(2, i)));
			}
			System.out.println("Sum of series of 2 raised to power of i :"+s);
	 }
}
