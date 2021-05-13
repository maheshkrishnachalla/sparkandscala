package in.scalapractice

import scala.util.control.Breaks._

import scala.math.sqrt
object PrimeorNotPrime {
  
   def main(args:Array[String]){
     println("Enter number :")
     var num = scala.io.StdIn.readInt()
     val rangeNum = 3 to num-1
     var count = 0
     breakable{
     var x=sqrt(num).toInt+1
     println("Squareroot of number ="+x)
     for(i<-3 to x by 2){
       println("Number Not divisible = "+i)
      if(num%i==0){
        println("Number divisible = "+i)
        count+=1
        break
      }
     }
     }
     if(count==1){
       println(num+" is Not Prime Number")
     }
     else{
       println(num+" is Prime Number")
     }
   }
}