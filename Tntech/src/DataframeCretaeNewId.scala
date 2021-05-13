import org.apache.spark.SparkConf

import org.apache.spark.sql.SparkSession
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.sql.types.DateType
import org.apache.spark.sql.functions._
import org.apache.spark.sql.Dataset
import org.apache.spark.sql.Row



object DataframeCretaeNewId extends App{

	Logger.getLogger("org").setLevel(Level.ERROR)

	val sparkConf = new SparkConf()
	sparkConf.set("spark.app.Name","Age column")
	sparkConf.set("spark.master", "local[2]")

	val spark = SparkSession.builder()
	.config(sparkConf)
	.getOrCreate()

	val myList = List((1,"2013-07-25",11599,"CLOSED"),
			(2,"2014-07-25",256,"PENDING_PAYMENT"),
			(3,"2013-07-25",11599,"COMPLETE"),
			(4,"2019-07-25",8827,"CLOSED")
			)

	import spark.implicits._

	val orderDf = spark.createDataFrame(myList)
	.toDF("orderid","order_date","order_customer_id","status")   

	val newDf = orderDf.withColumn("order_date",unix_timestamp(col("order_date").cast(DateType)))
	.withColumn("newid", monotonically_increasing_id())
	.dropDuplicates("order_date", "order_customer_id")
	.drop("orderid")
	.sort("order_date")
	
	
	newDf.printSchema()

	newDf.show()

	spark.stop()



}