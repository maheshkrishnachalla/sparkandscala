import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.sql.functions._


object ConcatColumns extends App{
  
  Logger.getLogger("org").setLevel(Level.ERROR)

	val sparkConf = new SparkConf()
	sparkConf.set("spark.app.Name","Concat columns")
	sparkConf.set("spark.master", "local[2]")

	val spark = SparkSession.builder()
	.enableHiveSupport()
	.config(sparkConf)
	.getOrCreate()
	
	var seq:Seq[(String,Int)] = Seq(("a",1),("b",1),("c",3),("d",4))
	
	import spark.implicits._
	
	val df = spark.sparkContext.parallelize(seq).toDF("k","v")
	
	df.select(concat($"k",lit(":"),$"v")).withColumnRenamed("concat(k, :, v)", "KV")
	.show()
  
}