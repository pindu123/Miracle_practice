package practice;
import java.util.*;
public class Cnt_chars {
public static void main(String[] args)
{
Scanner sc=new Scanner(System.in);
System.out.println("enter a string");
String s=sc.nextLine();

int wcnt=1;
int cnt=0;
int splcnt=0;
int vcnt=0;
int ccnt=0;

for(int i=1;i<s.length();i++)
{
if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u')
{
vcnt++;
}
else if(s.charAt(i)==' ')
{
wcnt++;
}
else if(s.charAt(i)>=48 && s.charAt(i)<=57)
{
cnt++;
}
else if(s.charAt(i)<=32 && s.charAt(i)<=47)
{
splcnt++;
}
else
{
ccnt++;
}

}
System.out.println("Number of words in string :"+wcnt);
System.out.println("Number of numbers in string :"+cnt);
System.out.println("Number of special characters in string :"+splcnt);
System.out.println("Number of vowels in string :"+vcnt);
System.out.println("Number of consonents in string :"+ccnt);

}
}
