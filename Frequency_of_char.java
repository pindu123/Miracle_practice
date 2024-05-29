package practice;
import java.util.*;
public class Frequency_of_char {
public static void main(String[] args)
{
Scanner sc=new Scanner(System.in);
System.out.println("enter a string");
String s=sc.nextLine();
//
//for(int i=0;i<s.length();i++)
//{
//int c=0;
//for(int j=0;j<s.length();j++)
//{
//if(s.substring(i,i+1).equals(s.substring(j,j+1)))
//{
//c++;
//}
//}
//System.out.println(s.charAt(i)+" is occuring "+c);
//}

HashMap<Character,Integer> hm=new HashMap<Character,Integer>();

for(int i=0;i<s.length();i++)
{
if(hm.containsKey(s.charAt(i)))
{
hm.put(s.charAt(i),hm.get(s.charAt(i))+1);

}
else
{
hm.put(s.charAt(i),1);
}
}

for(Map.Entry o:hm.entrySet())
{
System.out.println(o.getKey()+" is occuring "+o.getValue());
}
}
}