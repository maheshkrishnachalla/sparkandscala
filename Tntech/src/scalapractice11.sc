object scalapractice11 {

	case class Person(name:String,age:Int)
	
	// 1.class parameters are automatically promoted to fields
	val person1 = new Person("sai",22)        //> person1  : scalapractice11.Person = Person(sai,22)
	println(person1.name)                     //> sai
	
	// 2. case class have sensible toString
	println(person1.toString())               //> Person(sai,22)
	println(person1)                          //> Person(sai,22)
	
	// 3. equals and hashcode methods implemented already
	val person2 = new Person("sai",22)        //> person2  : scalapractice11.Person = Person(sai,22)
	println(person1==person2)                 //> true
	
	// 4. have companion objects already, we do not have to create it
	val person3 = Person.apply("Ram", 24)     //> person3  : scalapractice11.Person = Person(Ram,24)
	println(person3)                          //> Person(Ram,24)
	val person4 = Person.apply("Ram", 24)     //> person4  : scalapractice11.Person = Person(Ram,24)
	println(person4)                          //> Person(Ram,24)
	
	// 5. case class have a handy copy method
	
	val person5 = person2.copy(age=15)        //> person5  : scalapractice11.Person = Person(sai,15)
	println(person5)                          //> Person(sai,15)
	
	// 6. case classes are serializable
}