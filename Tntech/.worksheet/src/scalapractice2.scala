object scalapractice2 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(58); 
	def squareIt(x:Int):Int={
	x*x
	};System.out.println("""squareIt: (x: Int)Int""");$skip(37); 
	
	def cubeIt(x:Int):Int={
	x*x*x
	};System.out.println("""cubeIt: (x: Int)Int""");$skip(22); 
	println(squareIt(6));$skip(22); 
	
	println(cubeIt(8));$skip(52); 
	
	def transformIt(x:Int,f:Int=>Int):Int={
	f(x)
	};System.out.println("""transformIt: (x: Int, f: Int => Int)Int""");$skip(28); val res$0 = 
	
	transformIt(5, squareIt);System.out.println("""res0: Int = """ + $show(res$0));$skip(26); val res$1 = 
	
	transformIt(5, cubeIt);System.out.println("""res1: Int = """ + $show(res$1));$skip(27); val res$2 = 
	
	transformIt(3,x=>x*x*x);System.out.println("""res2: Int = """ + $show(res$2));$skip(26); val res$3 = 
	
	transformIt(4, x=>x+x);System.out.println("""res3: Int = """ + $show(res$3));$skip(39); 
	
	
	def divideBy(x:Int):Int={
	x/2
	};System.out.println("""divideBy: (x: Int)Int""");$skip(15); val res$4 = 
	
	divideBy(8);System.out.println("""res4: Int = """ + $show(res$4));$skip(27); val res$5 = 
	
	
	transformIt(4,x=>x/2);System.out.println("""res5: Int = """ + $show(res$5));$skip(38); val res$6 = 
	
	transformIt(2,x=>{val y=x*2; y*y});System.out.println("""res6: Int = """ + $show(res$6))}
}
