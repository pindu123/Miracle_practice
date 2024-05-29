package practice;
import java.util.*;
public class SampleExceptions {
public static void main(String[] args)
{
Scanner sc=new Scanner(System.in);

int a=sc.nextInt();
int b=sc.nextInt();

try{
System.out.println("sum : " +(a+b));
System.out.println("Sub :"+(a-b));
System.out.println("mul :"+(a*b));
System.out.println("div: "+(a/b));
}
catch(Exception e)
{
System.out.println(e);
System.out.println(e.getMessage());
e.printStackTrace();
}

}
}
