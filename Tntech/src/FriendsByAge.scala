import org.apache.spark.SparkContext
import org.apache.log4j.Level
import org.apache.log4j.Logger


object FriendsByAge extends App {

	def parseLine(line:String) ={
			val fields = line.split(",")
			val age =fields(2).toInt
			val friends =fields(3).toInt
			(age,friends)
	}

	Logger.getLogger("org").setLevel(Level.ERROR)

	val sc = new SparkContext("local[*]","FriendsByAge")

	val input = sc.textFile("D:\\BIGDATA\\Spark\\Spark Data\\spark-data\\friends-data.csv")

	val mappedInput = input.map(parseLine)
	
	//val mappedFinal = mappedInput.map(x=>(x._1,(x._2,1)))
	
	val mappedFinal = mappedInput.mapValues(x=>(x,1))

	val totalsByAge = mappedFinal.reduceByKey((x,y)=>(x._1+y._1,x._2+y._2))
	
	// val averagesByAge = totalsByAge.map(x=>(x._1,x._2._1/x._2._2)).sortBy(x=>x._2)
	
	val averagesByAge = totalsByAge.mapValues(x=>x._1/x._2).sortBy(x=>x._2)
	
	averagesByAge.collect().foreach(println)
	
	
}