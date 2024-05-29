package practice;
import java.util.*;
public class V_c_count {
public static void main(String[] args)
{
Scanner sc=new Scanner(System.in);
System.out.println("enter a string");
String s=sc.nextLine();
s=s.toLowerCase();
int vc=0;
int cc=0;
for(int i=0;i<s.length();i++)
{
if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u')
{
vc++;
}
else
{
cc++;
}
}
System.out.println("number of vowels in the string :"+vc);
System.out.println("number of consonants in the string :"+cc);

}
}
