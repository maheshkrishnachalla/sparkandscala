import org.apache.spark.SparkConf

import org.apache.spark.sql.SparkSession
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.types.StructField
import org.apache.spark.sql.types.IntegerType
import org.apache.spark.sql.types.TimestampType
import org.apache.spark.sql.types.StringType
import org.apache.commons.net.ntp.TimeStamp

case class Orders(orderid:Int,orderdate:TimeStamp,
    customerid:Int,status:String)
  

object DataframeExplicitSchema extends App{
  
  
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.Name","Explicit Schema")
  sparkConf.set("spark.master", "local[2]")
    
  val spark = SparkSession.builder()
  .config(sparkConf)
  .getOrCreate()
  
 /* val orderSchema = StructType(List(
      StructField("orderId",IntegerType),
      StructField("orderdate",TimestampType),
      StructField("customerid",IntegerType),
      StructField("status",StringType)
      ))*/

      val orderSchema = "orderid Int, orderdate String, customerId Int,status String"
      
   val ordersDf = spark.read
   .format("csv")
   .option("header", true)
   .schema(orderSchema)
  .option("path","D:\\BIGDATA\\Spark\\Spark Data\\orders.csv")
  .load()
  
  import spark.implicits._
  
  val ordersDs = ordersDf.as[Orders]
  
  ordersDs.filter(x=>x.orderid<10)
  
  ordersDf.printSchema()
  ordersDf.show()
  
  Logger.getLogger(getClass.getName).info("My Application is successfully completed")
  
  scala.io.StdIn.readLine()
  spark.stop()
  
  
  
}
