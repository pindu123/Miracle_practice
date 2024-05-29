package practice;
import java.util.*;
public class Eliminate_chars {
public static void main(String[] args)
{
Scanner sc=new Scanner(System.in);
System.out.println("enter a string");
String s=sc.nextLine();
String s1=s.toUpperCase();
String str="";
for(int i=0;i<s.length();i++)
{
if((s1.charAt(i)>='A' && s1.charAt(i)<='Z') )
{
 str=str+s.charAt(i);
}

}
System.out.println(str);

}
}
