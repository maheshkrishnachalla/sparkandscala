object scalapractice11 {

	case class Person(name:String,age:Int);import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(163); 
	
	// 1.class parameters are automatically promoted to fields
	val person1 = new Person("sai",22);System.out.println("""person1  : scalapractice11.Person = """ + $show(person1 ));$skip(23); 
	println(person1.name);$skip(72); 
	
	// 2. case class have sensible toString
	println(person1.toString());$skip(18); 
	println(person1);$skip(93); 
	
	// 3. equals and hashcode methods implemented already
	val person2 = new Person("sai",22);System.out.println("""person2  : scalapractice11.Person = """ + $show(person2 ));$skip(27); 
	println(person1==person2);$skip(108); 
	
	// 4. have companion objects already, we do not have to create it
	val person3 = Person.apply("Ram", 24);System.out.println("""person3  : scalapractice11.Person = """ + $show(person3 ));$skip(18); 
	println(person3);$skip(39); 
	val person4 = Person.apply("Ram", 24);System.out.println("""person4  : scalapractice11.Person = """ + $show(person4 ));$skip(18); 
	println(person4);$skip(83); 
	
	// 5. case class have a handy copy method
	
	val person5 = person2.copy(age=15);System.out.println("""person5  : scalapractice11.Person = """ + $show(person5 ));$skip(18); 
	println(person5)}
	
	// 6. case classes are serializable
}
