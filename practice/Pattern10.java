package practice;
import java.util.*;
public class Pattern10 {
public static void main(String[] args)
{
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();

for(int i=1;i<=n;i++)
{
for(int t=1;t<(n-i);t++)
{
System.out.println(" ");
}
//for(int j=i;j>=1;j--)
//{
//System.out.print(j+" ");
//}

for(int k=2;k<i;k++)
{
System.out.print(k+" ");
}
System.out.println(" ");
}


}
}
