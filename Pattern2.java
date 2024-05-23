package practice;
import java.util.*;
public class Pattern2 {
	public static void main(String[] args)
	 {
		 Scanner sc=new Scanner(System.in);
			System.out.println("enter a number");
			int n=sc.nextInt();
			int c=1;
			for(int i=1;i<=n;i++)
			{
				for(int j=1;j<=n-i;j++)
				{
				System.out.print(" ");	 
				}
				for(int j=1;j<=2*i-1;j++)
				{ 
					System.out.print("*");
				}
				System.out.println(" ");
				
				 
				 
			}
			for(int i=n-1;i>=0;i--)
			{
				for(int j=1;j<=n-i;j++)
				{
					System.out.print(" ");
				}
				for(int j=1;j<=2*i-1;j++)
				{
					System.out.print("*");
				}
				System.out.println(" ");
			}
}
}
