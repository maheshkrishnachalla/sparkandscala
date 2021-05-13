import org.apache.spark.SparkConf

import org.apache.spark.sql.SparkSession
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.sql.functions._
import org.apache.spark.sql.expressions.Window
import org.apache.hadoop.hdfs.server.namenode.INodeReference.WithCount

object DataframeWindowaggregates extends App{
  
  Logger.getLogger("org").setLevel(Level.ERROR)

	val sparkconf = new SparkConf()
	sparkconf.set("spark.app,name", "Window Aggregates")
	sparkconf.set("spark.master","local[2]")

	val spark = SparkSession.builder()
	.config(sparkconf)
	.getOrCreate()

  	val invoice = spark.read
	.format("csv")
	.option("delimiter", ",")
	.option("inferSchema", true)
	.option("path", "D:\\BIGDATA\\Spark\\Dataframe and Dataset\\windowdata.csv")
	.load()
	
	val invoiceDf = invoice.toDF("country","weeknum","numinvoices","totalquantity","invoicevalue")
	
	val window = Window.partitionBy("country")
	.orderBy("weeknum")
	.rowsBetween(Window.unboundedPreceding , Window.currentRow)
	
	val df = invoiceDf.withColumn("Runningtotal",
	    sum("invoicevalue").over(window))
	
	    
	 df.show()   
	spark.stop()
}