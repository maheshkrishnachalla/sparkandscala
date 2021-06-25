import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession


object SchemaMergeinParquet extends App{

	Logger.getLogger("org").setLevel(Level.ERROR)

	val sparkconf = new SparkConf()
	sparkconf.set("spark.app.name", "Schema Merge in Parquet")
	sparkconf.set("spark.master","local[*]")

	val spark = SparkSession.builder()
	.config(sparkconf)
	.getOrCreate()


	import spark.implicits._

	val squaresDf = spark.sparkContext
	.makeRDD(1 to 5).map(i=>(i,i*i))
	.toDF("value", "square")

	squaresDf.write.parquet("C:\\Users\\Admin\\Desktop\\data\\key=1");

	val cubesDf = spark.sparkContext.makeRDD(6 to 10)
			.map(i=>(i,i*i*i)).toDF("value","cube")


	squaresDf.write.parquet("C:\\Users\\Admin\\Desktop\\data\\key=2");

	val mergeddf = spark.read.option("mergeSchema", "true")
	.parquet("C:\\Users\\Admin\\Desktop\\data")
	
	mergeddf.printSchema()
	
	mergeddf.show(false)


}