object scalapractice3 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(50); 

	val a = Array(1,2,3,4,5);System.out.println("""a  : Array[Int] = """ + $show(a ));$skip(27); 
	println(a.mkString(","));$skip(26); ;
	
	for(i<-a){
	println(i)
	};$skip(13); 
	
	a(2)=6;$skip(27); 
	println(a.mkString(","));$skip(17); ;
	
	println(a(4));$skip(28); 
	
	val b =List(1,2,3,4,5,6);System.out.println("""b  : List[Int] = """ + $show(b ));$skip(15); 
	
	println(b);$skip(17); ;
	println(b.head);$skip(17); 
	println(b.tail);$skip(26); 
	
	for(i<-b){
	println(i)
	};$skip(16); val res$0 = 
	
	b.reverse;System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(9); val res$1 = 
	
	b.sum;System.out.println("""res1: Int = """ + $show(res$1));$skip(9); val res$2 = 
	
	10::b;System.out.println("""res2: List[Int] = """ + $show(res$2));$skip(37); 
	
	val c = ("Sairam",200000,29,true);System.out.println("""c  : (String, Int, Int, Boolean) = """ + $show(c ));$skip(8); val res$3 = 
	
	c._1;System.out.println("""res3: String = """ + $show(res$3));$skip(6); val res$4 = 
	c._2;System.out.println("""res4: Int = """ + $show(res$4));$skip(25); 
	
	val d = ("Sairam",10);System.out.println("""d  : (String, Int) = """ + $show(d ));$skip(24); 
	
	val e= 107->"Sairam";System.out.println("""e  : (Int, String) = """ + $show(e ));$skip(23); 
	
	
	val rng = 1 to 10;System.out.println("""rng  : scala.collection.immutable.Range.Inclusive = """ + $show(rng ));$skip(28); 
	
	for(i<-rng){
	println(i)
	};$skip(21); 
	
	val x=1 to 10;System.out.println("""x  : scala.collection.immutable.Range.Inclusive = """ + $show(x ));$skip(20); ;
	val p = 1 until 10;System.out.println("""p  : scala.collection.immutable.Range = """ + $show(p ));$skip(26); 
	
	for(i<-p){
	println(i)
	};$skip(40); 
	
	
	val z =Set(1,1,2,3,3,2,1,4,4,2);System.out.println("""z  : scala.collection.immutable.Set[Int] = """ + $show(z ));$skip(12); 
	println(z);$skip(9); val res$5 = 
	
	z.min;System.out.println("""res5: Int = """ + $show(res$5));$skip(7); val res$6 = 
	z.max;System.out.println("""res6: Int = """ + $show(res$6));$skip(9); val res$7 = 
	
	z.sum;System.out.println("""res7: Int = """ + $show(res$7));$skip(41); 
	
	val xy = Map(1->"Santhi",2->"Swetha");System.out.println("""xy  : scala.collection.immutable.Map[Int,String] = """ + $show(xy ))}
	
	
	}
	