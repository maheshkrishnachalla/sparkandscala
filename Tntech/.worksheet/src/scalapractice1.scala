object scalapractice1 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(67); 
  println("Welcome to the Scala worksheet");$skip(19); 
  println("Hello");$skip(25); 
  
  val a:String = "Hi";System.out.println("""a  : String = """ + $show(a ));$skip(13); 
  println(a);$skip(25); 
  
  var b:String = "Hi";System.out.println("""b  : String = """ + $show(b ));$skip(12); 
  b="there";$skip(13); 
  println(b);$skip(26); 
  
  
  val numberOne = 5;System.out.println("""numberOne  : Int = """ + $show(numberOne ));$skip(26); 
  
  val c:Boolean = true;System.out.println("""c  : Boolean = """ + $show(c ));$skip(22); 
  
  val d:Char = 'h';System.out.println("""d  : Char = """ + $show(d ));$skip(29); 
  
  val pi:Double = 1.34567;System.out.println("""pi  : Double = """ + $show(pi ));$skip(25); 
  
  val f :Float = 5.6f;System.out.println("""f  : Float = """ + $show(f ));$skip(31); 
  
  val e:Long = 12345578999l;System.out.println("""e  : Long = """ + $show(e ));$skip(31); 
  
  val smallNumber:Byte =127;System.out.println("""smallNumber  : Byte = """ + $show(smallNumber ));$skip(65); 
  
  println("combined result"+numberOne+c+d+pi+f+e+smallNumber);$skip(35); 
  
  
  var name:String = "sairam";System.out.println("""name  : String = """ + $show(name ));$skip(38); 
  println(s"Hello $name How are you");$skip(40); 
  
  println(f"value of pi is $pi%.2f");$skip(40); 
  
  println(raw"Hello how \n are you");$skip(19); 
  
  val abc = 1>2;System.out.println("""abc  : Boolean = """ + $show(abc ));$skip(26); 
  
  val x:String = "Sai";System.out.println("""x  : String = """ + $show(x ));$skip(23); 
  val y:String = "Sai";System.out.println("""y  : String = """ + $show(y ));$skip(15); 
  val z = x==y;System.out.println("""z  : Boolean = """ + $show(z ));$skip(49); 
  
  if(1>3) print("hello")
 	else println("hi");$skip(22); 
 	
 	
 	
 	val num =1;System.out.println("""num  : Int = """ + $show(num ));$skip(138); 
 	num match{
 	case 1 => println("one")
 	case 2 => println("two")
 	case 3 => println("three")
 	case _ => println("something else")
 	};$skip(40); 
 	
 	
 	for(x<-1 to 10){
 	println(x*x)
  };$skip(14); 
  var i=0;System.out.println("""i  : Int = """ + $show(i ));$skip(40); 
  while(i<=10){
  println(i)
  i+=1
  };$skip(7); 
   i=0;$skip(44); 
   do{
   println(i)
   i+=1
   }while(i<0);$skip(49); val res$0 = 
   
   {
   var h=10;
   h+7;
   h;
   10.0
   };System.out.println("""res0: Double = """ + $show(res$0));$skip(32); 
   
   println({var x=10;x+20})}
}
