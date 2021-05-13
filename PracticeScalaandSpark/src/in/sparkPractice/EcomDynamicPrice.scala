package in.sparkPractice

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.sql.functions._

object EcomDynamicPrice extends App{

	Logger.getLogger("org").setLevel(Level.ERROR)

	//setting log level
	val sparkConf = new SparkConf()

	//setting spark conf
	sparkConf.set("spark.app.name", "Click Stream")
	sparkConf.set("spark.master", "local[2]")

	//setting spark session
	val spark = SparkSession.builder()
	.config(sparkConf)
	.getOrCreate()

	val ecomCompetitorDf = spark.read.format("csv")
	.option("header", true)
	.option("inferSchema",true)
	.option("path", "D:\\BIGDATA\\Spark\\Spark week14\\ecom_competitor_data.txt")
	.load()

	val internalProductDf = spark.read.format("csv")
	.option("header", true)
	.option("delimiter", "|")
	.option("inferSchema",true)
	.option("path", "D:\\BIGDATA\\Spark\\Spark week14\\internal_product_data.txt")
	.load()

	val sellerDataDf = spark.read.format("csv")
	.option("header", true)
	.option("delimiter", "|")
	.option("inferSchema",true)
	.option("path", "D:\\BIGDATA\\Spark\\Spark week14\\seller_data.txt")
	.load()

	ecomCompetitorDf.printSchema()
	ecomCompetitorDf
	.groupBy("fetchTS")


	/*internalProductDf.printSchema()
	internalProductDf.show(40)
*/
	/*sellerDataDf.printSchema()
	sellerDataDf.show(40)
*/
	/*val ecomData = ecomCompetitorDf
	.groupBy("productId","rivalName").agg(min("price").as("MinPrice")).orderBy("productId")

	ecomData.show(50)
	
	val productData = internalProductDf.select("ProductId", "procuredValue","minMargin","maxMargin").orderBy("ProductId")

	productData.show(50)*/
	
	//val joinCondition =  ecomCompetitorDf.col("productId") === internalProductDf.col("ProductId")
  
  //val joinType ="inner"
  
  /*val joinedDf = ecomCompetitorDf.join(internalProductDf,joinCondition,joinType)
  .drop("category","subcategory","SellerID","lastModified")
  .drop(internalProductDf("ProductId"))
  */
  
  
  //joinedDf.show()
}