import scala.math.sqrt
import scala.util.control.Breaks._

object PrimeNumorNotPrimeNum extends App{
   
  def isPrime(n:Int):String={
     if(n==1){
			  return n+" is Neither Prime Nor Composite Number"
			}
     if(n==2){
			  return n+" is Prime Number"
			}
    var x = sqrt(n).toInt+1
    var count =0
    breakable{
    for(i<-2 to x){
      if(n%i==0){
         count+=1
        break
      }
    }
    }
    if(count==1){
    return n+" is Not Prime Number"
    }
    else{
      return n+" is Prime Number"
    }
  }
  try{
  while(true){  
    print("Enter Number : ")
  var num = scala.io.StdIn.readInt()
  val prime = isPrime(num)
  println(prime)
  }
  }
  catch{
    case e:NumberFormatException => println("..... Program terminated .....")
  }
}