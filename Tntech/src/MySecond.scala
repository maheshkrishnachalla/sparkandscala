

object MySecond extends App{
  
  val b = for(i<- 1 to 10) yield{
    i*i
  }
  println(b)
  
  val a = for(i<- 1 to 10) yield{
    if(i%2==0) i*i
  }
  
  println(a)
  
  val c =for(i<- 1 to 10; if i%2==0) yield{
    i*i
  }
  
  println(c)
  
  val d = for{i<- 1 to 10;
  if i%2==0
  }yield i*i
  
  println(d)
  
  
  def checkSign(num:Int):String={
    num match{
      case a if a>0=> s"$a is positive number"
      case b if b<0=> s"$b is negative number"
      case c=> s"$c is neither positive or negative number"
    }
  }
  
  println(checkSign(10))
  println(checkSign(-1))
  println(checkSign(0))

  def f(x:Option[Int]) = x match{
    case Some(i) if i%2 ==0 => println(i)
    case None => println("none")
    case _ => println("something else")
  }

  for(i <- 1 to 10) println(i*i)
  (1 to 10).foreach(i=>println(i*i))

  for(i <- 1 to 10) yield i*i
  
  (1 to 10).map(i=>i*i)
  
  
  val st1= new String("Venkatesh")
  val st2= new String("Venkatesh")
  
  println(st1==st2)
  println(st1.equals(st2))
  
  
  
  
  
  
  
  
  
  
}