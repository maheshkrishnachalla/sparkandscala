import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.log4j.Level
import org.apache.log4j.Logger


object DataframeExample3 extends App{
  
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.Name","My first application")
  sparkConf.set("spark.master", "local[2]")
    
  val spark = SparkSession.builder()
  .config(sparkConf)
  .getOrCreate()
  
  /*val ordersDf = spark.read
  .option("header", true)
  .option("inferSchema",true)
  .option("path","D:\\BIGDATA\\Spark\\Spark Data\\orders.csv")
  .load()*/
  
  
  val ordersDf = spark.read
  .format("json")
  .option("path","D:\\BIGDATA\\Spark\\Spark Data\\players.json")
  //.option("mode", "PERMISSIVE")
  //.option("mode", "DROPMALFORMED")
  .option("mode", "FAILFAST")
  .load()
  
  ordersDf.printSchema()
  ordersDf.show(false)  // it wont truncate the data ,show complete data in column
  
  Logger.getLogger(getClass.getName).info("My Application is successfully completed")
  
  scala.io.StdIn.readLine()
  spark.stop()
}