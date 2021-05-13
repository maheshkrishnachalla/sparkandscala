import org.apache.spark.SparkContext
import org.apache.log4j.Level
import org.apache.log4j.Logger


object GroupLoglevels extends App{

  Logger.getLogger("org").setLevel(Level.WARN)
    
     // Create a SparkContext using every core of the local machine
    val sc = new SparkContext("local[*]", "WordCount")   
    
   val baseRdd = sc.textFile("D:\\BIGDATA\\Spark\\Spark Data\\bigLog.txt")
   
   val mapRdd = baseRdd.map(x=>(x.split(":")(0),x.split(":")(1)))
   
   mapRdd.groupByKey().collect().foreach(x=>(println(x._1,x._2.size)))
   
   
    scala.io.StdIn.readLine()
   
   
}