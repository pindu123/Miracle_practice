package practice;

import java.util.Scanner;

public class Pattern7 {
	public static void main(String[] args)
	 {
		 Scanner sc=new Scanner(System.in);
			System.out.println("enter a number");
			int n=sc.nextInt();
			 
			for(int i=1;i<=n;i++)
			{
				int c=0;
				for(int j=1;j<=i;j++)
				{
					System.out.print(n-c+" ");
					c++;
					 
				}
				System.out.println(" ");
		 
			}
	 }
}
