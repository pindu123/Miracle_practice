package practice;
import java.util.*;
public class sampleOverload {
int sum()
{
return 10+20;
}
int sum(int a,int b)
{
return a+b;
}
int sum(int a,int b,int c)
{
return a+b+c;
}
public static void main(String[] args)
{
sampleOverload obj=new sampleOverload();
System.out.println("sum :"+obj.sum());

System.out.println("sum :"+obj.sum(30,40));
System.out.println("sum :"+obj.sum(40,50,60));

}
}
