import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.log4j.Level
import org.apache.log4j.Logger


object DataframeColumnStringObjectExpr extends App{

	Logger.getLogger("org").setLevel(Level.ERROR)

	val sparkConf = new SparkConf()
	sparkConf.set("spark.app.Name","Write in Table")
	sparkConf.set("spark.master", "local[2]")

	val spark = SparkSession.builder()
	.enableHiveSupport()
	.config(sparkConf)
	.getOrCreate()

	val ordersDf = spark.read
	.format("csv")
	.option("header", true)
	.option("inferSchema", true)
	.option("path","D:\\BIGDATA\\Spark\\Spark Data\\orders.csv")
	.load()
	
	import spark.implicits._
	
	ordersDf.select("order_id", "order_status").show
	
	//ordersDf.select(column("order_id"), col("order_date")).show
	
	ordersDf.select($"order_customer_id",'order_status).show
	
	
	ordersDf.selectExpr("order_id", "order_status","concat(order_status,'_STATUS')")
	.show(false)
	
	scala.io.StdIn.readLine()
  spark.stop()
	
	
}