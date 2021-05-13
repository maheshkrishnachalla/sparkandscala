object scalapractice10 {
  
  abstract class Person1{
  val ptype:String
  def eat
  def play = println("playing")
  }
  
  class Student1 extends Person1{
  def eat:Unit = println("eat work and sleep")
  }
  
  val s = new Student1
  s.eat
  
  trait Teacher{
  def meal
  }
  
  trait Parent{
  }
  
  class Child extends Teacher with Parent{
  def meal = println("eat")
  }
  
  val c = new Child
  
 	c.meal
  
}