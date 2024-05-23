package practice;

import java.util.Scanner;

public class Sum_series1 {
	public static void main(String[] args)
	 {
		 Scanner sc=new Scanner(System.in);
			System.out.println("enter a number");
			int n=sc.nextInt();
			double s=0;
			for(int i=1;i<n;i++)
			{
			s=s+(1/(double)(i*i));	
			}
			System.out.println("Sum of squares of series : "+s);
	 }
}
