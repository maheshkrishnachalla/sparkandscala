import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession


object DataframeForeachPartition extends App{
  
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.name", "Dataframe Foreach Partition")
  sparkConf.set("spark.master","local[2]")
  
  val spark = SparkSession.builder()
  .config(sparkConf)
  .getOrCreate()
  
  val rdd = spark.sparkContext.parallelize(Seq(1,2,3,4,5,6,7,8,9))
  
 /* rdd.foreachPartition(partition =>{
    
    partition.foreach(println)
  })*/
  
  
  val filter = rdd.filter(x=>(x%2==0))
  
  println(filter.count())
 
  scala.io.StdIn.readLine()
}