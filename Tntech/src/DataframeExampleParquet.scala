import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.log4j.Level
import org.apache.log4j.Logger


object DataframeExampleParquet extends App{
 
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.Name","My first application")
  sparkConf.set("spark.master", "local[2]")
    
  val spark = SparkSession.builder()
  .config(sparkConf)
  .getOrCreate()
  
  
  
  val ordersDf = spark.read
  .option("path","D:\\BIGDATA\\Spark\\Spark Data\\users.parquet")
  .load()
  
  ordersDf.printSchema()
  ordersDf.show(false)  // it wont truncate the data ,show complete data in column
  
  Logger.getLogger(getClass.getName).info("My Application is successfully completed")
  
  scala.io.StdIn.readLine()
  spark.stop()
}