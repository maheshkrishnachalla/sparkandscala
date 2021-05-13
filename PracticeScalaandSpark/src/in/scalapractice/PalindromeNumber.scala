package in.scalapractice

object PalindromeNumber {
  
   def main(args:Array[String]){
     println("Enter Number :")
     var n = scala.io.StdIn.readInt()
     var x= n
     var r:String=""
     while(n!=0){
       r=r+n%10+""
       n=n/10
    }
     if(r.toInt==x){
       println(x+" is Palindrome Number")
     }
     else{
       println(x+" is Not Palindrome Number")
     }
     }
   
  
}