import org.apache.spark.SparkContext
import org.apache.log4j.Level
import org.apache.log4j.Logger


object HCLInterview extends App{
  
  def ageFilter(lines:String)={
    val line = lines.split(",")
    if(line(1).toInt>18){
      "Y"
    }
    else{
      "N"
    }
  }
  
  Logger.getLogger("org").setLevel(Level.ERROR)

	val sc = new SparkContext("local[*]","FriendsByAge")

	val input = sc.textFile("D:\\BIGDATA\\Spark\\dataset1")
	
	val mappedAge = input.map(x=>(x,ageFilter(x)))
	
	mappedAge.collect().foreach(println)

  
}