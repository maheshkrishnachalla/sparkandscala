

object MyThird extends App{
  
  val r =7;
  lazy val area = {
    println("calculating area of circle")
    3.14*r*r
  }
  
  println(area)
  
  println(Math.sqrt(16))
  
  object Person{
    def apply(name:String,age:Int)={
      s"$name is $age years old"
    }
  }
  
  val x= Person("Rama",25)
  val y = Person.apply("Siri",22)
  println(x+","+y)
  
  case class Student(name:String,age:Int)
  
  val z =Student("Kavya",14)
  println(z)
  
  
  trait traitA{
    def name = println("Grand Parent trait")
  }
  
  trait traitB extends traitA{
    override def name = {
      println("B is child of A")
      super.name
    }
  }
  
  trait traitC extends traitA{
    override def name = {
      println("C is child of A")
      super.name
    }
  }
  
  object grandChild extends traitB with traitC
  
  grandChild.name
  
  var a ="samur"
  
  a = "56"
  
  try{
    val b =5/0
  }
  catch{
    case e:Exception=>println("please give denominator other than zero")
  }
  finally{
    println("I will always execute")
  }
  
  
  val list1 = List(1,2,3,4)
  val list2 =List(5,6,7,8)
  
  val p =list1.flatMap(x=>list2.map(y=>x+y))
  
  println(p)
  
  val l = 100::200::300::Nil
  
  println(l)
  
  val ls = 100 #::200 #::300 #::Stream.empty
  
  println(ls)
 ls.take(2).print
 
 val lz =Stream(1,2,3)
 println(lz)
 
 
 val myarr =Array.ofDim[Int](2,2)
 
 myarr(0)(0) =1
 myarr(0)(1) =2
 myarr(1)(0) =3
 myarr(1)(1) =4
 
 for(i <- 0 to 1;j <- 0 to 1){
   println(myarr(i)(j))
 }
 
 
 
 
 
 
  
  
}