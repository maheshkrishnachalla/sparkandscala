object scalapractice7 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(76); 

	def divideFunc(x:Double,y:Double):Double={
	x/y
	};System.out.println("""divideFunc: (x: Double, y: Double)Double""");$skip(20); val res$0 = 
	
	divideFunc(10,2);System.out.println("""res0: Double = """ + $show(res$0));$skip(41); 
	
	val inverse = divideFunc(1, _:Double);System.out.println("""inverse  : Double => Double = """ + $show(inverse ));$skip(15); val res$1 = 
	
	inverse(10);System.out.println("""res1: Double = """ + $show(res$1));$skip(42); 
	
	def sumFunc(x:Int,y:Int):Int={
	x+y
	};System.out.println("""sumFunc: (x: Int, y: Int)Int""");$skip(37); 
	
	val increment = sumFunc(1, _:Int);System.out.println("""increment  : Int => Int = """ + $show(increment ));$skip(17); val res$2 = 
	
	sumFunc(4, 8);System.out.println("""res2: Int = """ + $show(res$2));$skip(14); val res$3 = 
	increment(9);System.out.println("""res3: Int = """ + $show(res$3));$skip(62); 
	
	
	
	def genericSum(x:Int,y:Int,f:Int=>Int)={
	f(x)+f(y)
	};System.out.println("""genericSum: (x: Int, y: Int, f: Int => Int)Int""");$skip(28); val res$4 = 
	
	genericSum(2, 3, x=>x+x);System.out.println("""res4: Int = """ + $show(res$4));$skip(28); val res$5 = 
	
	genericSum(2, 3, x=>x*x);System.out.println("""res5: Int = """ + $show(res$5));$skip(55); 
	
	val sumofSquares = genericSum(_:Int, _:Int, x=>x*x);System.out.println("""sumofSquares  : (Int, Int) => Int = """ + $show(sumofSquares ));$skip(21); val res$6 = 
	
	sumofSquares(5,6);System.out.println("""res6: Int = """ + $show(res$6));$skip(59); 
	
	
	def generSum(f:Int=>Int)(x:Int,y:Int)={
	f(x)+f(y)
	};System.out.println("""generSum: (f: Int => Int)(x: Int, y: Int)Int""");$skip(25); val res$7 = 
	
	generSum(x=>x*x)(3,4);System.out.println("""res7: Int = """ + $show(res$7));$skip(39); 
	
	val sumofSquare = generSum(x=>x*x)_;System.out.println("""sumofSquare  : (Int, Int) => Int = """ + $show(sumofSquare ));$skip(20); val res$8 = 
	
	sumofSquare(3,4);System.out.println("""res8: Int = """ + $show(res$8))}
	
	
}
