object scalapractice8 {

	class Person(val name:String,val age:Int);import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(102); 
	
	val p = new Person("Sairam",22);System.out.println("""p  : scalapractice8.Person = """ + $show(p ));$skip(19); 
	
	println(p.name);$skip(16); 
	println(p.age)
	
	class Person1(name:String,age:Int){
	
	val x =20;
	
	def ageDoubler = 2*age
	
	def salaryDoubler(salary:Double):Double=salary*2
	};$skip(178); 
	val person =  new Person1("Venkatesha",14);System.out.println("""person  : scalapractice8.Person1 = """ + $show(person ));$skip(21); 
	
	println(person.x);$skip(28); 
	println(person.ageDoubler);$skip(38); 
	println(person.salaryDoubler(50000))
	
	object Person2{
	val N =2
	def canFly:Boolean=false
	}
	
	class Person2(val name:String,val age:Int){
	 
	 def salaryDoubler(salary:Int) = salary*2
	};$skip(192); 
	
	val p2 = new Person2("Sridevi",22);System.out.println("""p2  : scalapractice8.Person2 = """ + $show(p2 ));$skip(36); 
	val p3 = new Person2("Sridevi",22);System.out.println("""p3  : scalapractice8.Person2 = """ + $show(p3 ));$skip(16); 
	val x= Person2;System.out.println("""x  : scalapractice8.Person2.type = """ + $show(x ));$skip(22); 
	
	println(Person2.N);$skip(25); 
	println(Person2.canFly);$skip(22); 
	
	val mary = Person2;System.out.println("""mary  : scalapractice8.Person2.type = """ + $show(mary ));$skip(22); 
	
	val john = Person2;System.out.println("""john  : scalapractice8.Person2.type = """ + $show(john ));$skip(23); 
	
	println(mary==john);$skip(28); val res$0 = 
	
	p2.salaryDoubler(100000);System.out.println("""res0: Int = """ + $show(res$0));$skip(19); 
	
	println(p2.age);$skip(19); 
	
	println(p2==p3)}
}
