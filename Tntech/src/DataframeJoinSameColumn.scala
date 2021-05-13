import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.sql.functions._

object DataframeJoinSameColumn extends App{

	Logger.getLogger("org").setLevel(Level.ERROR)

	val sparkconf = new SparkConf()
	sparkconf.set("spark.app,name", "DataFrameExammple 7")
	sparkconf.set("spark.master","local[2]")

	val spark = SparkSession.builder()
	.config(sparkconf)
	.getOrCreate()

	val customersDf = spark.read
	.format("csv")
	.option("header",true)
	.option("path", "D:\\BIGDATA\\Spark\\Dataframe and Dataset\\customers.csv")
	.load

	val ordersDf = spark.read
	.format("csv")
	.option("header", true)
	.option("inferSchema", true)
	.option("path","D:\\BIGDATA\\Spark\\Spark Data\\orders.csv")
	.load()
	
	spark.sql("SET spark.sql.autoBroadcastJoinThreshold = -1")

	val neworderDf = ordersDf.withColumnRenamed("order_customer_id", "cust_id")

	val joincondition = neworderDf.col("cust_id")===customersDf.col("customer_id")

	val joinType = "inner"

	val joinDf = neworderDf.join(broadcast(customersDf),joincondition,joinType)
	/*.drop(neworderDf.col("cust_id"))
	.select("order_id","customer_id","customer_fname")
	.sort("order_id")
	.withColumn("order_id", expr("coalesce(order_id,-1)"))*/
	joinDf.show()

	scala.io.StdIn.readLine()
	spark.stop()

}