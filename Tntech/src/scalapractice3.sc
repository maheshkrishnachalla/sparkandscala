object scalapractice3 {

	val a = Array(1,2,3,4,5)                  //> a  : Array[Int] = Array(1, 2, 3, 4, 5)
	println(a.mkString(","));                 //> 1,2,3,4,5
	
	for(i<-a){
	println(i)                                //> 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
                                                  //| 5
	}
	
	a(2)=6
	println(a.mkString(","));                 //> 1,2,6,4,5
	
	println(a(4))                             //> 5
	
	val b =List(1,2,3,4,5,6)                  //> b  : List[Int] = List(1, 2, 3, 4, 5, 6)
	
	println(b);                               //> List(1, 2, 3, 4, 5, 6)
	println(b.head)                           //> 1
	println(b.tail)                           //> List(2, 3, 4, 5, 6)
	
	for(i<-b){
	println(i)                                //> 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
                                                  //| 5
                                                  //| 6
	}
	
	b.reverse                                 //> res0: List[Int] = List(6, 5, 4, 3, 2, 1)
	
	b.sum                                     //> res1: Int = 21
	
	10::b                                     //> res2: List[Int] = List(10, 1, 2, 3, 4, 5, 6)
	
	val c = ("Sairam",200000,29,true)         //> c  : (String, Int, Int, Boolean) = (Sairam,200000,29,true)
	
	c._1                                      //> res3: String = Sairam
	c._2                                      //> res4: Int = 200000
	
	val d = ("Sairam",10)                     //> d  : (String, Int) = (Sairam,10)
	
	val e= 107->"Sairam"                      //> e  : (Int, String) = (107,Sairam)
	
	
	val rng = 1 to 10                         //> rng  : scala.collection.immutable.Range.Inclusive = Range 1 to 10
	
	for(i<-rng){
	println(i)                                //> 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
                                                  //| 5
                                                  //| 6
                                                  //| 7
                                                  //| 8
                                                  //| 9
                                                  //| 10
	}
	
	val x=1 to 10;                            //> x  : scala.collection.immutable.Range.Inclusive = Range 1 to 10
	val p = 1 until 10                        //> p  : scala.collection.immutable.Range = Range 1 until 10
	
	for(i<-p){
	println(i)                                //> 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
                                                  //| 5
                                                  //| 6
                                                  //| 7
                                                  //| 8
                                                  //| 9
	}
	
	
	val z =Set(1,1,2,3,3,2,1,4,4,2)           //> z  : scala.collection.immutable.Set[Int] = Set(1, 2, 3, 4)
	println(z)                                //> Set(1, 2, 3, 4)
	
	z.min                                     //> res5: Int = 1
	z.max                                     //> res6: Int = 4
	
	z.sum                                     //> res7: Int = 10
	
	val xy = Map(1->"Santhi",2->"Swetha")     //> xy  : scala.collection.immutable.Map[Int,String] = Map(1 -> Santhi, 2 -> Swe
                                                  //| tha)
	
	
	}
	