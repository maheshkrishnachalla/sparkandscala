import scala.collection.mutable.ArrayBuffer


object MyFourth extends App{
  
  trait Computer {
    def ram:String
    def hdd:String
    def cpu:String
  }
  
  case class PC(ram:String,hdd:String,cpu:String) extends Computer
  
  case class Laptop(ram:String,hdd:String,cpu:String) extends Computer
  
  object ComputerFactory{
    
    def apply(compType:String,ram:String,hdd:String,cpu:String)=compType match{
      case "PC" => PC(ram,hdd,cpu)
      case "Laptop" => Laptop(ram,hdd,cpu)
    }
 
  }
  
  val x= ComputerFactory("PC","16gb","1tb","2.3gz")
  val y = ComputerFactory("Laptop","16gb","1tb","2.3gz")
  println(x)
  println(y)
  
  
  val arrBuffer= ArrayBuffer(1,2,3,4)
  arrBuffer+=5
  arrBuffer.append(6)
  println(arrBuffer)
  
  val a = Array(1,2,3,4,4)
  
  println(a.toSet)
  
  a.distinct.foreach(i=>print(i+" "))
  
  val b =List("a","b","b","c")
  println(b.toSet.toList)
  
  
  
  
  
  
  
  
  
}