import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.log4j.Level
import org.apache.log4j.Logger


object DataframeSimpleJoin extends App{
 
   Logger.getLogger("org").setLevel(Level.ERROR)

	val sparkconf = new SparkConf()
	sparkconf.set("spark.app,name", "Simple Join")
	sparkconf.set("spark.master","local[2]")

	val spark = SparkSession.builder()
	.config(sparkconf)
	.getOrCreate()
	
	val orderDf = spark.read
	.format("csv")
	.option("header", true)
	.option("inferSchema", true)
	.option("path", "D:\\BIGDATA\\Spark\\Spark Data\\orders.csv")
	.load
	
	val customerDf = spark.read
	.format("csv")
	.option("header", true)
	.option("inferSchema", true)
	.option("path", "D:\\BIGDATA\\Spark\\Dataframe and Dataset\\customers.csv")
	.load()
	
	
	val joinCondition = orderDf.col("order_customer_id") === customerDf.col("customer_id")
	
	val joinType = "right"
	
	val joindf = orderDf.join(customerDf,joinCondition,joinType)
	.sort("order_customer_id")
	.select("order_id","customer_id", "customer_fname")
	
	joindf.show()
	
	
	scala.io.StdIn.readLine()
	spark.stop()
	
}