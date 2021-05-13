object scalapractice9 {
  
	class Person{
	def eat = println("eat food");
	}
	
	class Girl extends Person{
	
	def meal = println("Milk")
	};import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(162); 
	
	val girl = new Girl;System.out.println("""girl  : scalapractice9.Girl = """ + $show(girl ));$skip(11); 
	girl.meal}
}
