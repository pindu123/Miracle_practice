package practice;
import java.util.*;
public class Replace_previous {
public static void main(String[] args)
{
Scanner sc=new Scanner(System.in);
System.out.println("enter a String");
String s=sc.nextLine();

String str=s.charAt(s.length()-1)+s.substring(1);
 
for(int i=0;i<s.length();i++)
{
if(s.charAt(i)==' '  )
{
str=str.substring(0,i+1)+s.charAt(i-1)+s.substring(i+2);
 
}

}

System.out.println(str);
}
}
