import org.apache.spark.SparkContext

import org.apache.log4j.Level
import org.apache.log4j.Logger
import scala.io.Source


object BooringWords extends App{
  
  def loadBooringWords():Set[String]={
    var booringWord:Set[String] = Set()
    val lines = Source.fromFile("D:\\BIGDATA\\Spark\\Spark Data\\boringwords.txt").getLines()
    
    for(line <- lines){
      booringWord+=line
    }
    
    booringWord
  }
  
  Logger.getLogger("org").setLevel(Level.ERROR)
 
 val sc = new SparkContext("local[*]","TopCustomerPurchases")
  
 var nameSet = sc.broadcast(loadBooringWords)
 
 val input = sc.textFile("D:\\BIGDATA\\Spark\\bigdata-campaign-data.csv")
 
 val mappedInput = input.map(x=>(x.split(",")(10).toFloat,x.split(",")(0)))
 
 val words = mappedInput.flatMapValues(x=>x.split(" ")) 
 
 val finalMapped = words.map(x=>(x._2.toLowerCase(),x._1))
 
 val filtered_rdd =finalMapped.filter(x=> !nameSet.value(x._1))
 
 val total = filtered_rdd.reduceByKey((x,y)=>x+y) 
 
 val sorted = total.sortBy(x=>x._2,false)
 
 sorted.take(20).foreach(println)
 
  
}