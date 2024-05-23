package practice;

import java.util.Scanner;

public class SeriesSum {
	public static void main(String[] args)
	 {
		 Scanner sc=new Scanner(System.in);
			System.out.println("enter a number");
			int n=sc.nextInt();
			double s=0;
			for(int i=1;i<=n;i++)
			{
				s=s+(1/(double)i);
			}
			System.out.println("Sum of series :"+s);
	 }
}
