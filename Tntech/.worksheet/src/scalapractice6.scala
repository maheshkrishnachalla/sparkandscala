object scalapractice6 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(77); 
  
  def areaofCircle ={val pi=3.145;(x:Int)=>pi*x*x};System.out.println("""areaofCircle: => Int => Double""");$skip(17); 
  
  val pi =3.5;System.out.println("""pi  : Double = """ + $show(pi ));$skip(21); 
  val a=areaofCircle;System.out.println("""a  : Int => Double = """ + $show(a ));$skip(10); val res$0 = 
  
  a(2);System.out.println("""res0: Double = """ + $show(res$0));$skip(7); val res$1 = 
  a(4);System.out.println("""res1: Double = """ + $show(res$1));$skip(7); val res$2 = 
  a(7);System.out.println("""res2: Double = """ + $show(res$2));$skip(16); 
  
  var  b = 5;System.out.println("""b  : Int = """ + $show(b ));$skip(27); 
  var c = println("Hello");System.out.println("""c  : Unit = """ + $show(c ));$skip(32); 
  
  val d = if(b>1) 1 else 2.5;System.out.println("""d  : Double = """ + $show(d ));$skip(45); 
  
  val e = if(b>1) 1 else println("Hello");System.out.println("""e  : AnyVal = """ + $show(e ));$skip(32); 
  
  val f = if(b>2) 'a' else 4;System.out.println("""f  : Int = """ + $show(f ));$skip(42); 
  
  val g = if(b>2) 2.5 else List(1,2,3);System.out.println("""g  : Any = """ + $show(g ));$skip(18); 
  
  
  val x = 3;System.out.println("""x  : Int = """ + $show(x ));$skip(11); 
  val y= 4;System.out.println("""y  : Int = """ + $show(y ));$skip(20); 
  
  var z = x.+(y);System.out.println("""z  : Int = """ + $show(z ));$skip(16); 
  
  z = x.*(y);$skip(22); 
  
  val p = 1 to 100;System.out.println("""p  : scala.collection.immutable.Range.Inclusive = """ + $show(p ));$skip(16); val res$3 = 
  
  p.map(_*2);System.out.println("""res3: scala.collection.immutable.IndexedSeq[Int] = """ + $show(res$3));$skip(17); val res$4 = 
 
 p.reduce(_+_);System.out.println("""res4: Int = """ + $show(res$4))}
  
}
