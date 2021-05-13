import org.apache.spark.SparkContext
import org.apache.log4j.Level
import org.apache.log4j.Logger
import java.util.Calendar

object TotalSpent extends App{

  Logger.getLogger("org").setLevel(Level.ERROR)
  
  
 val sc = new SparkContext("local[*]","TotalSpent")
  
 val input = sc.textFile("D:\\BIGDATA\\Spark\\Spark Data\\spark-data\\customer-orders.csv")
 
 val mapInput = input.map(x=>(x.split(",")(0),x.split(",")(2).toFloat))
 
 //val mapInput = input.map(x=>x.split(","))
 
 //val mapInput2 = mapInput.map(x=>(x(0),x(2).toFloat))

 val totalofCustomers = mapInput.reduceByKey((x,y) => x+y)
 
 //val count = totalofCustomers.sortBy(x => x._2)
 
 val premiumcustomers = totalofCustomers.filter(x=>x._2>5000)
 
 val doubleAmount = premiumcustomers.map(x=>x._2*2).cache()
 
 
//doubleAmount.saveAsTextFile("D:\\BIGDATA\\Spark\\Spark Data\\spark-data\\now1")
 
 //count.collect.foreach(println)
 
 doubleAmount.collect().foreach(println)
 
 println(doubleAmount.count()) 
scala.io.StdIn.readLine()
}