package practice;
import java.util.*;
public class Occurance_char {
public static void main(String[] args)
{
Scanner sc=new Scanner(System.in);
System.out.println("enter a string"); 
String s=sc.nextLine();
char max=' ';
char min=' ';
int mx=Integer.MIN_VALUE;
int mn=Integer.MAX_VALUE;
for(int i=0;i<s.length();i++)
{
int c=0;
for(int j=0;j<s.length();j++)
{
if(s.substring(i,i+1).equals(s.substring(j,j+1)))
{
c++;
}
}
if(c>mx)
{
max=s.charAt(i);
mx=c;
}
if(c<mn)
{
min=s.charAt(i);
mn=c;
}

}
System.out.println("Minimum occuring character :"+min);
System.out.println("Maximum occuring character :"+max);

}

}
