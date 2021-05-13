object scalapractice8 {

	class Person(val name:String,val age:Int)
	
	val p = new Person("Sairam",22)           //> p  : scalapractice8.Person = scalapractice8$Person@25f38edc
	
	println(p.name)                           //> Sairam
	println(p.age)                            //> 22
	
	class Person1(name:String,age:Int){
	
	val x =20;
	
	def ageDoubler = 2*age
	
	def salaryDoubler(salary:Double):Double=salary*2
	}
	val person =  new Person1("Venkatesha",14)//> person  : scalapractice8.Person1 = scalapractice8$Person1$1@6bdf28bb
	
	println(person.x)                         //> 20
	println(person.ageDoubler)                //> 28
	println(person.salaryDoubler(50000))      //> 100000.0
	
	object Person2{
	val N =2
	def canFly:Boolean=false
	}
	
	class Person2(val name:String,val age:Int){
	 
	 def salaryDoubler(salary:Int) = salary*2
	}
	
	val p2 = new Person2("Sridevi",22)        //> p2  : scalapractice8.Person2 = scalapractice8$Person2$3@6b71769e
	val p3 = new Person2("Sridevi",22)        //> p3  : scalapractice8.Person2 = scalapractice8$Person2$3@2752f6e2
	val x= Person2                            //> x  : scalapractice8.Person2.type = scalapractice8$Person2$2$@e580929
	
	println(Person2.N)                        //> 2
	println(Person2.canFly)                   //> false
	
	val mary = Person2                        //> mary  : scalapractice8.Person2.type = scalapractice8$Person2$2$@e580929
	
	val john = Person2                        //> john  : scalapractice8.Person2.type = scalapractice8$Person2$2$@e580929
	
	println(mary==john)                       //> true
	
	p2.salaryDoubler(100000)                  //> res0: Int = 200000
	
	println(p2.age)                           //> 22
	
	println(p2==p3)                           //> false
}