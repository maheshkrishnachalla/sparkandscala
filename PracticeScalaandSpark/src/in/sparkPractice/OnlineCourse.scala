package in.sparkPractice

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.sql.SaveMode

object OnlineCourse extends App{
 
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

	val chaptersDf = spark.read.format("csv")
	//.option("header", true)
	.option("inferSchema",true)
	.option("path", "D:\\BIGDATA\\Spark\\Spark Data\\Coursesdata\\chapters.csv")
	.load()
	
	chaptersDf.printSchema()
	chaptersDf.show()
	
	val chaptersHeaderDf = spark.read.format("csv")
	//.option("header", true)
	.option("path", "D:\\BIGDATA\\Spark\\Spark Data\\Coursesdata\\chapters-header.csv")
	.load()
	
	chaptersHeaderDf.show()
	
	val titlesDf = spark.read.format("csv")
	//.option("header", true)
	.option("inferSchema",true)
	.option("path", "D:\\BIGDATA\\Spark\\Spark Data\\Coursesdata\\titles.csv")
	.load()
	
	titlesDf.printSchema()
	titlesDf.show()
	
  val titlesHeaderDf = spark.read.format("csv")
	//.option("header", true)
	.option("path", "D:\\BIGDATA\\Spark\\Spark Data\\Coursesdata\\titles-header.csv")
	.load()
	
	titlesHeaderDf.show()
	
	
	val viewsDf1 = spark.read.format("csv")
	//.option("header", true)
	.option("inferSchema",true)
	.option("path", "D:\\BIGDATA\\Spark\\Spark Data\\Coursesdata\\views-1.csv")
	.load()
	
	val viewsDf2 = spark.read.format("csv")
	//.option("header", true)
	.option("inferSchema",true)
	.option("path", "D:\\BIGDATA\\Spark\\Spark Data\\Coursesdata\\views-2.csv")
	.load()
	
	val viewsDf3 = spark.read.format("csv")
	//.option("header", true)
	.option("inferSchema",true)
	.option("path", "D:\\BIGDATA\\Spark\\Spark Data\\Coursesdata\\views-3.csv")
	.load()
	
	val viewsHeaderDf = spark.read.format("csv")
	//.option("header", true)
	.option("path", "D:\\BIGDATA\\Spark\\Spark Data\\Coursesdata\\viewsHeader.csv")
	.load()
	
	viewsHeaderDf.show()
	
	viewsDf1.printSchema()
	viewsDf1.show()
	
	viewsDf2.printSchema()
	viewsDf2.show()
	
	viewsDf3.printSchema()
	viewsDf3.show()
	
	
}