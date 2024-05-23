package practice;
import java.util.*;

public class Perfect {
public static void main(String[] args)
{
	Scanner sc=new Scanner(System.in);
	System.out.println("enter a number");
	int n=sc.nextInt();
	int temp=n;
	int s=0;
	int i=1;
	while(i<n)
	{
	if(n%i==0)
	{
		s=s+i;
	}
	i++;
	}
	if(s==temp)
	{
		System.out.println("Perfect number");
	}
	else
	{
 
		System.out.println("Not a perfect number");
	 
	}
	
}
}
