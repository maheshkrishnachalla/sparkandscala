object scalapractice6 {
  
  def areaofCircle ={val pi=3.145;(x:Int)=>pi*x*x}//> areaofCircle: => Int => Double
  
  val pi =3.5                                     //> pi  : Double = 3.5
  val a=areaofCircle                              //> a  : Int => Double = scalapractice6$$$Lambda$8/483422889@1d251891
  
  a(2)                                            //> res0: Double = 12.58
  a(4)                                            //> res1: Double = 50.32
  a(7)                                            //> res2: Double = 154.10500000000002
  
  var  b = 5                                      //> b  : Int = 5
  var c = println("Hello")                        //> Hello
                                                  //| c  : Unit = ()
  
  val d = if(b>1) 1 else 2.5                      //> d  : Double = 1.0
  
  val e = if(b>1) 1 else println("Hello")         //> e  : AnyVal = 1
  
  val f = if(b>2) 'a' else 4                      //> f  : Int = 97
  
  val g = if(b>2) 2.5 else List(1,2,3)            //> g  : Any = 2.5
  
  
  val x = 3                                       //> x  : Int = 3
  val y= 4                                        //> y  : Int = 4
  
  var z = x.+(y)                                  //> z  : Int = 7
  
  z = x.*(y)
  
  val p = 1 to 100                                //> p  : scala.collection.immutable.Range.Inclusive = Range 1 to 100
  
  p.map(_*2)                                      //> res3: scala.collection.immutable.IndexedSeq[Int] = Vector(2, 4, 6, 8, 10, 12
                                                  //| , 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 42, 44, 46, 48, 50
                                                  //| , 52, 54, 56, 58, 60, 62, 64, 66, 68, 70, 72, 74, 76, 78, 80, 82, 84, 86, 88
                                                  //| , 90, 92, 94, 96, 98, 100, 102, 104, 106, 108, 110, 112, 114, 116, 118, 120,
                                                  //|  122, 124, 126, 128, 130, 132, 134, 136, 138, 140, 142, 144, 146, 148, 150, 
                                                  //| 152, 154, 156, 158, 160, 162, 164, 166, 168, 170, 172, 174, 176, 178, 180, 1
                                                  //| 82, 184, 186, 188, 190, 192, 194, 196, 198, 200)
 
 p.reduce(_+_)                                    //> res4: Int = 5050
  
}