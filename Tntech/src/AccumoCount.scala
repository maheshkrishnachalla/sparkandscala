import org.apache.spark.SparkContext
import org.apache.log4j.Level
import org.apache.log4j.Logger


object AccumoCount extends App{
  
  Logger.getLogger("org").setLevel(Level.ERROR)
  
   val sparkContext=new SparkContext("local[*]","AccumoCount")
   
   val input = sparkContext.textFile("D:\\BIGDATA\\Spark\\samplefile.txt")
   
   val accum = sparkContext.longAccumulator("blank line accumolator")
  
   val count = input.foreach(x=>if(x=="") accum.add(1))
   
   println(accum.value)   
   
   
   
}