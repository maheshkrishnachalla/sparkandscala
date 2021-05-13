object scalapractice1 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  println("Hello")                                //> Hello
  
  val a:String = "Hi"                             //> a  : String = Hi
  println(a)                                      //> Hi
  
  var b:String = "Hi"                             //> b  : String = Hi
  b="there"
  println(b)                                      //> there
  
  
  val numberOne = 5                               //> numberOne  : Int = 5
  
  val c:Boolean = true                            //> c  : Boolean = true
  
  val d:Char = 'h'                                //> d  : Char = h
  
  val pi:Double = 1.34567                         //> pi  : Double = 1.34567
  
  val f :Float = 5.6f                             //> f  : Float = 5.6
  
  val e:Long = 12345578999l                       //> e  : Long = 12345578999
  
  val smallNumber:Byte =127                       //> smallNumber  : Byte = 127
  
  println("combined result"+numberOne+c+d+pi+f+e+smallNumber)
                                                  //> combined result5trueh1.345675.612345578999127
  
  
  var name:String = "sairam"                      //> name  : String = sairam
  println(s"Hello $name How are you")             //> Hello sairam How are you
  
  println(f"value of pi is $pi%.2f")              //> value of pi is 1.35
  
  println(raw"Hello how \n are you")              //> Hello how \n are you
  
  val abc = 1>2                                   //> abc  : Boolean = false
  
  val x:String = "Sai"                            //> x  : String = Sai
  val y:String = "Sai"                            //> y  : String = Sai
  val z = x==y                                    //> z  : Boolean = true
  
  if(1>3) print("hello")
 	else println("hi")                        //> hi
 	
 	
 	
 	val num =1                                //> num  : Int = 1
 	num match{
 	case 1 => println("one")
 	case 2 => println("two")
 	case 3 => println("three")
 	case _ => println("something else")
 	}                                         //> one
 	
 	
 	for(x<-1 to 10){
 	println(x*x)                              //> 1
                                                  //| 4
                                                  //| 9
                                                  //| 16
                                                  //| 25
                                                  //| 36
                                                  //| 49
                                                  //| 64
                                                  //| 81
                                                  //| 100
  }
  var i=0                                         //> i  : Int = 0
  while(i<=10){
  println(i)
  i+=1
  }                                               //> 0
                                                  //| 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
                                                  //| 5
                                                  //| 6
                                                  //| 7
                                                  //| 8
                                                  //| 9
                                                  //| 10
   i=0
   do{
   println(i)
   i+=1
   }while(i<0)                                    //> 0
   
   {
   var h=10;
   h+7;
   h;
   10.0
   }                                              //> res0: Double = 10.0
   
   println({var x=10;x+20})                       //> 30
}