import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.sql.SaveMode
import org.apache.spark.sql.functions._



object AvroFiles extends App{
  
  Logger.getLogger("org").setLevel(Level.ERROR)

	val sparkConf = new SparkConf()
	sparkConf.set("spark.app.Name","Avro File Formats")
	sparkConf.set("spark.master", "local[2]")

	val spark = SparkSession.builder()
	.enableHiveSupport()
	.config(sparkConf)
	.getOrCreate()
	
	import spark.implicits._
	
	val readDf = spark.read
	.option("header",true)
	.option("inferSchema", true)
	.csv("D:\\BIGDATA\\Spark\\Spark Data\\orders.csv")
	
	 val groupedDf = readDf.groupBy("order_date", "order_customer_id")
	 .agg(count("order_id"))
	 .withColumnRenamed("count(order_id)", "orders")
	 .orderBy(desc("orders"))
	 
	 //groupedDf.explain(true)
	
	 
	groupedDf.coalesce(1).
	write.format("avro")
	.mode(SaveMode.Overwrite)
	.save("D:\\BIGDATA\\Spark\\Spark Data\\ordersAvro2")
	
	
  
}