object scalapractice10 {
  
  abstract class Person1{
  val ptype:String
  def eat
  def play = println("playing")
  }
  
  class Student1 extends Person1{
  def eat:Unit = println("eat work and sleep")
  };import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(232); 
  
  val s = new Student1;System.out.println("""s  : scalapractice10.Student1 = """ + $show(s ));$skip(8); 
  s.eat
  
  trait Teacher{
  def meal
  }
  
  trait Parent{
  }
  
  class Child extends Teacher with Parent{
  def meal = println("eat")
  };$skip(159); 
  
  val c = new Child;System.out.println("""c  : scalapractice10.Child = """ + $show(c ));$skip(12); 
  
 	c.meal}
  
}
