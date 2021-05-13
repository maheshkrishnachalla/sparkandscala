import org.apache.spark.SparkContext
import org.apache.log4j.Level
import org.apache.log4j.Logger


object WordCountofSearchText extends App{
  
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  val sc = new SparkContext("local[*]","wordcount")
  
  val input = sc.textFile("D:\\BIGDATA\\Spark\\Spark Data\\search_data.txt")
  
  val words = input.flatMap(x=>x.split(" "))
  
  val wordsLower = words.map(x=>x.toLowerCase())
  
  val wordMap = wordsLower.map(x=>(x,1))
  
  val finalCount = wordMap.reduceByKey((x,y)=>x+y)
  
  val finalCount2 = finalCount.map(x=>(x._2,x._1)).sortByKey(false).map(x=>(x._2,x._1))
  
  val results = finalCount2.collect()
  for(result <- results){
    val word = result._1
    val count = result._2
    println(word+" : "+count)
  }
  
  scala.io.StdIn.readLine();
  
  
}