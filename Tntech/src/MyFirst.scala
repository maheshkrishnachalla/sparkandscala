

object MyFirst extends App{

	println("Hello World")

	def add(num:Int=8,incrementBy:Int=1)={
			num+incrementBy
	}
	println(add(incrementBy=7))

	def printFn(name:String*)={
			for(i <- name){
				println(i)
			}
	}

	printFn("Hello","How","are","you")


	def tryIt(thing:Null):Unit={
			println("that worked")
	}

	tryIt(null) 


	val c =Nil
	println(c)

	def fun ={
			throw new Exception
	}

	//fun

	def getStringMaybe(num:Int):Option[String]={
			if(num>=0) Some("positive number")
			else None
	}

	def printResult(num:Int)={
			getStringMaybe(num) match {
			case Some(str)=> println(str)
			case None =>println("No String")
			}
	}

	printResult(10)
	printResult(-1)


	def funcNew()= println("Hello World")

	funcNew()


case class Address(city:String,state:String,zip:String)

/*class User(email:String,password:String){
    var firstName:String=_
    var lastName:String=_
    var address:Address =_ 
    }

  val user= new User("tntech@gmail.com","abcd")
  println(user.firstName.length())*/

class User(email:String,password:String){
		var firstName:Option[String]=None
				var lastName:Option[String]=None
				var address:Option[Address] =None
	}

	val user= new User("tntech@gmail.com","abcd")
			println(user.firstName.getOrElse("<Not Assigned>"))

			user.firstName = Some("SaiRam")
			user.lastName = Some("Jaya")
			user.address = Some(Address("Hyderabad","TG","540042"))

			println(user.firstName.getOrElse("<Not Assigned>"))
			println(user.lastName.getOrElse("<Not assigned>"))
			println(user.address.getOrElse("<Not Assigned"))


}