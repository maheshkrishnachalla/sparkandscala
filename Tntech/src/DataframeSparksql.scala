import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.log4j.Level
import org.apache.log4j.Logger


object DataframeSparksql extends App{
  
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.Name","Spark SQL")
  sparkConf.set("spark.master", "local[2]")
  
  
  val spark = SparkSession.builder()
  .config(sparkConf)
  .getOrCreate()
  
  val ordersDf  = spark.read
  .option("header", true)
  .option("inferSchema",true)
  .csv("D:\\BIGDATA\\Spark\\Spark Data\\orders.csv")
  
  ordersDf.createOrReplaceTempView("orders")
  
 /* val resultDf = spark.sql("select order_status,count(order_status)"
        +" as status_count from orders group by order_status "+
        " order by status_count desc")*/
     
  val resultDfs = spark.sql("select order_customer_id, count(order_id) "
      +" as orders_count from orders where order_status ='CLOSED' "
      +" group by order_customer_id order by orders_count desc")      
        
        
  // resultDf.show()
   resultDfs.show()
  
  scala.io.StdIn.readLine()
  spark.stop()
}