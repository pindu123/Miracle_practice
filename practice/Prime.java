package practice;
import java.util.*;
public class Prime {
public static void main(String[] args)
{
	Scanner sc=new Scanner(System.in);
	System.out.println("enter a number");
	int n=sc.nextInt();
	
	for(int i=1;i<=n;i++)
	{
		int c=0;
		for(int j=1;j<=n;j++)
		{
			if(i%j==0)
			{
				c++;
			}
		}
		if(c==2)
		{
			System.out.println(i);
			
		}
	}
	
}
}
