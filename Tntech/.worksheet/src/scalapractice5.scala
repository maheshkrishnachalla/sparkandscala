object scalapractice5 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(125); 
  
	def factortial(n:Int):Int={
	var result:Int =1
	for(i<- 1 to n){
	result = result*i
	}
	result
	};System.out.println("""factortial: (n: Int)Int""");$skip(17); val res$0 = 
	
	factortial(6);System.out.println("""res0: Int = """ + $show(res$0));$skip(70); 
	
	
	def factor(n:Int):Int ={
	if(n==1| n==0)1
	else n*factor(n-1)
	};System.out.println("""factor: (n: Int)Int""");$skip(14); val res$1 = 
	
	factor(10);System.out.println("""res1: Int = """ + $show(res$1));$skip(92); 
	
	
	def fact(n:Int,result:Int):Int = {
	if(n==1 | n==0) result
	else fact(n-1,result*n)
	};System.out.println("""fact: (n: Int, result: Int)Int""");$skip(14); val res$2 = 
	
	fact(10,1);System.out.println("""res2: Int = """ + $show(res$2));$skip(34); 
	
	val a = println("Hello World");System.out.println("""a  : Unit = """ + $show(a ));$skip(11); 
	
	val b=6;System.out.println("""b  : Int = """ + $show(b ));$skip(26); 
	val x= if(b==6) 5 else 7;System.out.println("""x  : Int = """ + $show(x ))}
	
}
