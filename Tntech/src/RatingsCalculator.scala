import org.apache.spark.SparkContext
import org.apache.log4j.Level
import org.apache.log4j.Logger
import scala.collection.script.Reset


object RatingsCalculator extends App{
  
  Logger.getLogger("org").setLevel(Level.ERROR)
  
   val sc = new SparkContext("local[*]","TopMovies")
   
   val input = sc.textFile("D:\\BIGDATA\\Spark\\Spark Data\\spark-data\\movie-data.data")
   
   val mappedInput = input.map(x=>x.split("\t")(2))
   
   val results = mappedInput.countByValue();
   
  /* val ratingsMap = mappedInput.map(x=>(x,1))
   
   val finalCount = ratingsMap.reduceByKey((x,y)=>x+y)
   
   val results = finalCount.collect()*/
   
   results.foreach(println)
  
}