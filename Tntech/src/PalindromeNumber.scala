

object PalindromeNumber extends App{

	def isPalindrome(n:Int):Boolean ={
			var r = 0
					var num = n
					while(num!=0){
						r = r*10 + num%10
								num=num/10
					}
			if(r==n )
				return true
						else
							return false
	}

	try{
		while(true){
		  print("Enter Number : ")
			var n = scala.io.StdIn.readInt()
					val palindrome = isPalindrome(n)
					if(palindrome)
						println(n+" is Palindrome Number")
						else
							println(n+" is Not Palindrome Number")
		
		}
	}catch{
	case e : NumberFormatException => println("..... Program terminated ....")
	}
}