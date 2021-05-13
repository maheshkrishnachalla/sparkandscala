
import scala.util.control.Breaks._

import scala.math.sqrt

object PrimeNumbersRange extends App{

	def isPrime(n:Int):Boolean={
	  if(n==2){
				return true
			}
	  if(n==1){
				return false
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

			if(count!=1){
				return true
			}
			else{
				return false
			}
	}
	try{
		while(true){  
			print("Enter Start Number : \n")
			var start = scala.io.StdIn.readInt()
			print("Enter End Number : \n")
			var end = scala.io.StdIn.readInt()
			if(start<=end && start>=1 && end>=1){
				for(i<- start to end){ 
				  var prime = isPrime(i)
				  if(prime==true){
				    print(i+",")
				  }
		    }
			}
			println()
		}
	}
	catch{
	case e:NumberFormatException => println("..... Program terminated .....")
	}
}