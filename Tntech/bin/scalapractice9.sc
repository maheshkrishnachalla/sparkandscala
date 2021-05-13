object scalapractice9 {
  
	class Person{
	def eat = println("eat food");
	}
	
	class Girl extends Person{
	
	def meal = println("Milk")
	}
	
	val girl = new Girl                       //> girl  : scalapractice9.Girl = scalapractice9$Girl@1a86f2f1
	girl.meal                                 //> Milk
}