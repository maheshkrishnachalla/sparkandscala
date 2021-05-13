import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.sql.SaveMode


object DataframeWriteinTable extends App{
  
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.Name","Write in Table")
  sparkConf.set("spark.master", "local[2]")
    
  val spark = SparkSession.builder()
  .enableHiveSupport()
  .config(sparkConf)
  .getOrCreate()
  
   //val orderSchema = "orderid Int, orderdate String, customerId Int,status String"
      
   val ordersDf = spark.read
   .format("csv")
   .option("header", true)
   //.schema(orderSchema)
   .option("inferSchema", true)
  .option("path","D:\\BIGDATA\\Spark\\Spark Data\\orders.csv")
  .load()
  
  spark.sql("create database if not exists retail")
  
  ordersDf.write
  .format("csv")
  .mode(SaveMode.Overwrite)
  .bucketBy(4, "order_customer_id")
  .sortBy("order_customer_id")
  .saveAsTable("retail.orders_1")
  
  spark.catalog.listTables("retail").show
  
  scala.io.StdIn.readLine()
  spark.stop()
  
}