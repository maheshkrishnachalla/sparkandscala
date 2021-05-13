package in.scalapractice
import scala.util.control.Breaks._
import scala.math.sqrt

object PrimeNumbers {

	def main(arg:Array[String]){
		println("Enter First Number :")
		val firstNumber = scala.io.StdIn.readInt()
		println("Enter Second Number :")
		val secondNumber = scala.io.StdIn.readInt()
		var nums = firstNumber to secondNumber
		
			for(n<-nums){
					var x= (sqrt(n)).toInt+1
					breakable{
							for(i<-2 to x){
								if(n%i==0){
								 break
								}
							}
					println(n)
					
					}

				
			}

		}
	}