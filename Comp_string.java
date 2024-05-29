package practice;
import java.util.*;
public class Comp_string {
static void compare(String s1,String s2)
{
if(s1.equals(s2))
{
System.out.println("Strings are equal");
}
else
{
System.out.println("Strings are not equal");
}

}
public static void main(String[] args)
{
Scanner sc=new Scanner(System.in);
System.out.println("enter two strings");
String s1=sc.nextLine();
String s2=sc.nextLine();

compare(s1,s2);
}
}
