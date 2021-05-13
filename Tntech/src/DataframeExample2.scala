import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.sql.Dataset
import org.apache.spark.sql.Row
import java.sql.Timestamp

case class OrdersData(order_id:Integer,order_date:Timestamp,order_customer_id:Integer,order_status:String)
    
    
object DataframeExample2 extends App{
  
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.Name","My first application")
  sparkConf.set("spark.master", "local[2]")
  
  
  val spark = SparkSession.builder()
  .config(sparkConf)
  .getOrCreate()
  
  
  val ordersDf : Dataset[Row] = spark.read
  .option("header", true)
  .option("inferSchema",true)
  .csv("D:\\BIGDATA\\Spark\\Spark Data\\orders.csv")
  
  import spark.implicits._
  
  val ordersDs = ordersDf.as[OrdersData]
  
  ordersDs.filter(x=>x.order_id<10).show

  
  //ordersDf.filter("orders_ids<10").show()
  
  Logger.getLogger(getClass.getName).info("My Application is successfully completed")
  
  scala.io.StdIn.readLine()
  spark.stop()
}