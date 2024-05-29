package practice;
import java.util.*;
public class Reverse_alpha {
public static void main(String[] args)
{
Scanner sc=new Scanner(System.in);
System.out.println("enter a string");
String s=sc.nextLine();
char[] a=s.toCharArray();
Arrays.sort(a);
for(int i=a.length-1;i>=0;i--){
System.out.println(a[i]);
}
 
}
}
