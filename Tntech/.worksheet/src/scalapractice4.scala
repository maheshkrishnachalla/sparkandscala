object scalapractice4 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(33); 

	var a=5;System.out.println("""a  : Int = """ + $show(a ));$skip(6); 
  a=7;$skip(38); 
	def func(x:Int):Int={
	return a+x
	};System.out.println("""func: (x: Int)Int""");$skip(11); val res$0 = 
	
	func(3);System.out.println("""res0: Int = """ + $show(res$0));$skip(41); 
	
	def funct(i:Int):Int={
	return i+1
	};System.out.println("""funct: (i: Int)Int""");$skip(12); val res$1 = 
	
	funct(6);System.out.println("""res1: Int = """ + $show(res$1));$skip(47); 
	
	
	
	def doubler(i:Int):Int={
	return 2*i
	};System.out.println("""doubler: (i: Int)Int""");$skip(22); 
	
	var t= doubler(_);System.out.println("""t  : Int => Int = """ + $show(t ));$skip(17); ;
	
	println(t(7));$skip(36); 
	
	def tripler(i:Int):Int={
	i*3
	};System.out.println("""tripler: (i: Int)Int""");$skip(43); 
	
	def fn(i:Int,f:Int=>Int):Int={
	f(i)
	};System.out.println("""fn: (i: Int, f: Int => Int)Int""");$skip(26); 
	
	println(fn(5,tripler));$skip(29); 
	
	def ft = {
	x:Int=>x*x
	};System.out.println("""ft: => Int => Int""");$skip(7); val res$2 = 
	ft(6);System.out.println("""res2: Int = """ + $show(res$2));$skip(19); 
	
	var rn =1 to 10;System.out.println("""rn  : scala.collection.immutable.Range.Inclusive = """ + $show(rn ));$skip(17); val res$3 = 
	rn.map(doubler);System.out.println("""res3: scala.collection.immutable.IndexedSeq[Int] = """ + $show(res$3));$skip(17); val res$4 = 
	rn.map(tripler);System.out.println("""res4: scala.collection.immutable.IndexedSeq[Int] = """ + $show(res$4));$skip(18); val res$5 = 
	
	rn.map(x=>x*x);System.out.println("""res5: scala.collection.immutable.IndexedSeq[Int] = """ + $show(res$5))}
}
