object scalapractice4 {

	var a=5                                   //> a  : Int = 5
  a=7
	def func(x:Int):Int={
	return a+x
	}                                         //> func: (x: Int)Int
	
	func(3)                                   //> res0: Int = 10
	
	def funct(i:Int):Int={
	return i+1
	}                                         //> funct: (i: Int)Int
	
	funct(6)                                  //> res1: Int = 7
	
	
	
	def doubler(i:Int):Int={
	return 2*i
	}                                         //> doubler: (i: Int)Int
	
	var t= doubler(_);                        //> t  : Int => Int = scalapractice4$$$Lambda$8/483422889@7c75222b
	
	println(t(7))                             //> 14
	
	def tripler(i:Int):Int={
	i*3
	}                                         //> tripler: (i: Int)Int
	
	def fn(i:Int,f:Int=>Int):Int={
	f(i)
	}                                         //> fn: (i: Int, f: Int => Int)Int
	
	println(fn(5,tripler))                    //> 15
	
	def ft = {
	x:Int=>x*x
	}                                         //> ft: => Int => Int
	ft(6)                                     //> res2: Int = 36
	
	var rn =1 to 10                           //> rn  : scala.collection.immutable.Range.Inclusive = Range 1 to 10
	rn.map(doubler)                           //> res3: scala.collection.immutable.IndexedSeq[Int] = Vector(2, 4, 6, 8, 10, 12
                                                  //| , 14, 16, 18, 20)
	rn.map(tripler)                           //> res4: scala.collection.immutable.IndexedSeq[Int] = Vector(3, 6, 9, 12, 15, 1
                                                  //| 8, 21, 24, 27, 30)
	
	rn.map(x=>x*x)                            //> res5: scala.collection.immutable.IndexedSeq[Int] = Vector(1, 4, 9, 16, 25, 3
                                                  //| 6, 49, 64, 81, 100)
}