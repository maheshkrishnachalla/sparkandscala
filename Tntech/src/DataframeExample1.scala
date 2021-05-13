import org.apache.spark.sql.SparkSession
import org.apache.spark.SparkConf
import org.apache.log4j.Level
import org.apache.log4j.Logger


object DataframeExample1 extends App{

  
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.Name","My first application")
  sparkConf.set("spark.master", "local[2]")
  
  
  val spark = SparkSession.builder()
  .config(sparkConf)
  .getOrCreate()
  
  
  val ordersDf = spark.read
  .option("header", true)
  .option("inferSchema",true)
  .csv("D:\\BIGDATA\\Spark\\Spark Data\\orders.csv")
  
  val groupDf = ordersDf
  .repartition(4)
  .where("order_customer_id>10000")
  .select("order_id","order_customer_id")
  .groupBy("order_customer_id")
  .count()
  
  groupDf.foreach(x=>println(x))
  
  groupDf.show()
  
  Logger.getLogger(getClass.getName).info("My Application is successfully completed")
  
  scala.io.StdIn.readLine()
  spark.stop()
  
}