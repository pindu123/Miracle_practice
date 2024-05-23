package practice;
import java.util.*;
public class Pattern11 {
 public static void main(String[] args)
{
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();

for(int i=n;i>0;i--)
{
for(int j=1;j<n-i;j++)
{
System.out.print(" ");
}

for(int j=1;j<=i;j++)
{
System.out.print(j+" ");
}
System.out.println(" ");

}


for(int i=1;i<=n;i++)
{
for(int j=1;j<=n-i;j++)
{
System.out.print(" ");
}

for(int j=1;j<=i;j++)
{
System.out.print(j+" ");
}
System.out.println(" ");

}
}
}
