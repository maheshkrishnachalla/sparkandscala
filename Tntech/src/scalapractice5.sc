object scalapractice5 {
  
	def factortial(n:Int):Int={
	var result:Int =1
	for(i<- 1 to n){
	result = result*i
	}
	result
	}                                         //> factortial: (n: Int)Int
	
	factortial(6)                             //> res0: Int = 720
	
	
	def factor(n:Int):Int ={
	if(n==1| n==0)1
	else n*factor(n-1)
	}                                         //> factor: (n: Int)Int
	
	factor(10)                                //> res1: Int = 3628800
	
	
	def fact(n:Int,result:Int):Int = {
	if(n==1 | n==0) result
	else fact(n-1,result*n)
	}                                         //> fact: (n: Int, result: Int)Int
	
	fact(10,1)                                //> res2: Int = 3628800
	
	val a = println("Hello World")            //> Hello World
                                                  //| a  : Unit = ()
	
	val b=6                                   //> b  : Int = 6
	val x= if(b==6) 5 else 7                  //> x  : Int = 5
	
}