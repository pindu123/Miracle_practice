package practice;
class Animal
{
void eat()
{
System.out.println("cat drinks milk");
}
void move()
{
System.out.println("cat walks using 4 legs");
}
}
public class SampleOverride extends Animal{

void eat()
{
System.out.println("Cow eats grass");
}
public static void main(String[] args)
{
SampleOverride o=new SampleOverride();
o.eat();
o.move();

Animal a=new Animal();
a.eat();
}
}
