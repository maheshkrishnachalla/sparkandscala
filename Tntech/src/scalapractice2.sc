object scalapractice2 {
	def squareIt(x:Int):Int={
	x*x
	}                                         //> squareIt: (x: Int)Int
	
	def cubeIt(x:Int):Int={
	x*x*x
	}                                         //> cubeIt: (x: Int)Int
	println(squareIt(6))                      //> 36
	
	println(cubeIt(8))                        //> 512
	
	def transformIt(x:Int,f:Int=>Int):Int={
	f(x)
	}                                         //> transformIt: (x: Int, f: Int => Int)Int
	
	transformIt(5, squareIt)                  //> res0: Int = 25
	
	transformIt(5, cubeIt)                    //> res1: Int = 125
	
	transformIt(3,x=>x*x*x)                   //> res2: Int = 27
	
	transformIt(4, x=>x+x)                    //> res3: Int = 8
	
	
	def divideBy(x:Int):Int={
	x/2
	}                                         //> divideBy: (x: Int)Int
	
	divideBy(8)                               //> res4: Int = 4
	
	
	transformIt(4,x=>x/2)                     //> res5: Int = 2
	
	transformIt(2,x=>{val y=x*2; y*y})        //> res6: Int = 16
}