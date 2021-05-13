
object EvenNumorOddNum extends App{

	def number(x:Int):String ={
			if (x%2==0) return "Even Number"
					else return "Odd Number"
	}
	
		try{
		  while(true){
		  print("Enter Number : ")
			var num = scala.io.StdIn.readInt();
			val evenorOdd = number(num)
					println(num+" is "+evenorOdd)
		  }
		}
		catch{
		case e: NumberFormatException => 
		  println("....... Program terminated.......")
		}	
}