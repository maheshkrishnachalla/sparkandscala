package in.scalapractice

object EvenorOdd {
  
   def main(args:Array[String]){
     println("Enter the Number :")
     var num = scala.io.StdIn.readInt()
     if(num%2==0){
       println(num+" is Even Number")
     }
     else{
       println(num+" is Odd Number")
     }
   }
  
}