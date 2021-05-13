object scalapractice7 {

	def divideFunc(x:Double,y:Double):Double={
	x/y
	}                                         //> divideFunc: (x: Double, y: Double)Double
	
	divideFunc(10,2)                          //> res0: Double = 5.0
	
	val inverse = divideFunc(1, _:Double)     //> inverse  : Double => Double = scalapractice7$$$Lambda$8/483422889@7c75222b
	
	inverse(10)                               //> res1: Double = 0.1
	
	def sumFunc(x:Int,y:Int):Int={
	x+y
	}                                         //> sumFunc: (x: Int, y: Int)Int
	
	val increment = sumFunc(1, _:Int)         //> increment  : Int => Int = scalapractice7$$$Lambda$9/93122545@7c30a502
	
	sumFunc(4, 8)                             //> res2: Int = 12
	increment(9)                              //> res3: Int = 10
	
	
	
	def genericSum(x:Int,y:Int,f:Int=>Int)={
	f(x)+f(y)
	}                                         //> genericSum: (x: Int, y: Int, f: Int => Int)Int
	
	genericSum(2, 3, x=>x+x)                  //> res4: Int = 10
	
	genericSum(2, 3, x=>x*x)                  //> res5: Int = 13
	
	val sumofSquares = genericSum(_:Int, _:Int, x=>x*x)
                                                  //> sumofSquares  : (Int, Int) => Int = scalapractice7$$$Lambda$12/997110508@1e6
                                                  //| 43faf
	
	sumofSquares(5,6)                         //> res6: Int = 61
	
	
	def generSum(f:Int=>Int)(x:Int,y:Int)={
	f(x)+f(y)
	}                                         //> generSum: (f: Int => Int)(x: Int, y: Int)Int
	
	generSum(x=>x*x)(3,4)                     //> res7: Int = 25
	
	val sumofSquare = generSum(x=>x*x)_       //> sumofSquare  : (Int, Int) => Int = scalapractice7$$$Lambda$16/142666848@3f3a
                                                  //| fe78
	
	sumofSquare(3,4)                          //> res8: Int = 25
	
	
}