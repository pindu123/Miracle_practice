package practice;
import java.util.*;
public class Pattern16 {
public static void main(String[] args)
{
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
for(int i=n;i>=0;i--)
{
for(int j=1;j<=i;j++)
{
System.out.print("*");
}

int c=1;
for(int k=n;k>=i;k--)
{
System.out.print(c);
c++;
}
System.out.println(" ");
}
}
}
