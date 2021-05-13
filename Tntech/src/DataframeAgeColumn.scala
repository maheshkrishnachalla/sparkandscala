import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.sql.functions._
import org.apache.spark.sql.Dataset
import org.apache.spark.sql.Row

object DataframeAgeColumn extends App{
  
  case class Person(name:String,age:Int,city:String)
  Logger.getLogger("org").setLevel(Level.ERROR)

  def ageCheck(age:Int) ={
    if(age>18) "Y"
    else "N"
  }
  
	val sparkConf = new SparkConf()
	sparkConf.set("spark.app.Name","Age column")
	sparkConf.set("spark.master", "local[2]")

	val spark = SparkSession.builder()
	.config(sparkConf)
	.getOrCreate()
	
	val df = spark.read
	.format("csv")
	.option("inferSchema", true)
	.option("path","D:\\BIGDATA\\Spark\\dataset1")
	.load()

	import spark.implicits._
	
	val df1:Dataset[Row] = df.toDF("name","age","city")
	
	//val ds1 = df1.as[Person]
	
  /*val parseAge = udf(ageCheck(_:Int):String) 
  val df2 = df1.withColumn("adult",parseAge(col("age")))*/
  
  spark.udf.register("parseAge", ageCheck(_:Int):String)
  val df2 = df1.withColumn("adult",expr("parseAge(age)"))
  
   df2.show()
  
  spark.catalog.listFunctions().filter(x=>x.name=="parseAge").show()
	
  df1.createOrReplaceTempView("peopletable")
  
  spark.sql("select name,age,city, parseAge(age) as adult from peopletable")
  .show()
  
  
  
  spark.stop()
}