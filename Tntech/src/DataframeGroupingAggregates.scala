import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.sql.functions._


object DataframeGroupingAggregates extends App{

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

	val sumDf1  = invoiceDf.groupBy("Country", "InvoiceNo")
	.agg(sum("Quantity").as("TotalQuantity"),
			sum(expr("Quantity *UnitPrice").as("InvoiceValue"))
			)

	val sumDf2 =	invoiceDf.groupBy("Country", "InvoiceNo")
	.agg(expr("sum(Quantity) as TotalQuantity"),
			expr("sum(Quantity * UnitPrice) as InoviceValue"))
			
			
			invoiceDf.createOrReplaceTempView("sales")
			
			val sumDf3 = spark.sql("""select Country,InvoiceNo,
			   sum(Quantity) as TotalQuantity,
			   sum(Quantity * UnitPrice) as InoviceValue from sales
			   group by Country,InvoiceNo """)

	sumDf1.show()

	sumDf2.show()
	
	sumDf3.show()

	spark.stop()
}