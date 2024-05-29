package practice;

interface Shape
{
 void square();
  void circle();
}
public class SampleAbstraction implements Shape {
 public void square()
 {
 System.out.println(" It's a square");
 }
 
  public  void circle()
 {
  System.out.println(" It's a Circle");
}
 public static void main(String[] args)
 {
  SampleAbstraction obj=new SampleAbstraction();
  
  obj.square();
  obj.circle();
 Shape a=new  SampleAbstraction();
 a.square();
 a.circle();
 System.out.println(a);
 }
}
