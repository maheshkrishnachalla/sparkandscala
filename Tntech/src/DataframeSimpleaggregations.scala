import org.apache.spark.SparkConf

import org.apache.spark.sql.SparkSession
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.sql.functions._
import org.apache.spark.sql.Dataset
import org.apache.spark.sql.Row



object DataframeSimpleaggregations extends App{
  
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  val sparkconf = new SparkConf()
   sparkconf.set("spark.app,name", "DataFrameExammple 7")
   sparkconf.set("spark.master","local[2]")
   
   val spark = SparkSession.builder()
   .config(sparkconf)
   .getOrCreate()
  
   val invoiceDf = spark.read.format("csv")
   .option("header",true)
   .option("inferSchema",true)
   .option("path","D:\\BIGDATA\\Spark\\Dataframe and Dataset\\order_data.csv")
   .load()
  
   invoiceDf.select(count("*").as("RowCount"),
       sum("Quantity").as("TotalQuantity"),
       avg("UnitPrice").as("AvgPrice"),
       countDistinct("InvoiceNo").as("CountDistinct"))
       .show()
       
   invoiceDf.selectExpr("count(StockCode) as RowCount",
       "sum(Quantity) as TotalQuantity",
       "avg(UnitPrice) as AvgPrice",
       "count(Distinct(InvoiceNo)) as CountDistinct")
       .show()
       
       
      invoiceDf.createOrReplaceTempView("sales")
      
      spark.sql("select count(*), sum(Quantity),avg(UnitPrice) "
       +" ,count(distinct(InvoiceNo)) from sales")
       .show()
   
       
   //invoiceDf.show()
   
   spark.stop()
}