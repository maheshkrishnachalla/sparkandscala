import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object DataframeGroupBy extends App{

	Logger.getLogger("org").setLevel(Level.ERROR)

	val sparkConf = new SparkConf()
	sparkConf.set("spark.app.name", "Dataframe GroupBy")
	sparkConf.set("spark.master", "local[2]")

	val spark = SparkSession.builder()
	.config(sparkConf)
	.getOrCreate()

	import spark.implicits._
	val data = Seq(("James","Sales","NY",90000,34,10000),
			("Michael","Sales","NY",86000,56,20000),
			("Robert","Sales","CA",81000,30,23000),
			("Maria","Finance","CA",90000,24,23000),
			("Raman","Finance","CA",99000,40,24000),
			("Scott","Finance","NY",83000,36,19000),
			("Jen","Finance","NY",79000,53,15000),
			("Jeff","Marketing","CA",80000,25,18000),
			("Kumar","Marketing","NY",91000,50,21000)
			)

	val df = data.toDF("employee_name","department","state","salary","age","bonus")		

	df.show()

	/*val groupDf = df.groupBy("department").count()

	groupDf.show()

	val groupDf2 = df.groupBy("department","state").count()

	groupDf2.show()*/

	/*df.groupBy("department").min("salary").show()

	df.groupBy("department").max("salary").show()

	df.groupBy("department").avg("salary").show()

	df.groupBy("department").sum("salary").show()*/

	/*df.groupBy("department")
	.agg(sum("salary").as("sum_salary")
			,max("salary").as("max_salary"),
			min("salary").as("min_salary"),
			round(avg("salary")).as("avg_salary"),
			sum("bonus").as("sum_bonus"))
	.where(col("sum_bonus")>5000)
	.orderBy(col("max_salary").desc )
	.show(false)*/

  println("approx_distinct_count : "
      +df.select(approx_count_distinct("salary")).collect()(0)(0))
      
  val df2 = df.select(countDistinct("department","salary"))
  df2.show(false)
  
  println("distinct count of department and salary : "+df2.collect()(0)(0))

  df.select(sum("salary")).show()
}