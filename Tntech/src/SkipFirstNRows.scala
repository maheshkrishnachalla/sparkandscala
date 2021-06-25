import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql.Dataset
import org.apache.spark.sql.Dataset
import org.apache.spark.sql.Row
import org.apache.spark.sql.types.LongType
import org.apache.spark.sql.expressions.Window



object SkipFirstNRows extends App{

	Logger.getLogger("org").setLevel(Level.ERROR)

	val sparkConf = new SparkConf()
	sparkConf.set("spark.app.Name", "Skip First N rows")
	sparkConf.set("spark.master", "local[2]")

	val spark = SparkSession.builder()
	.config(sparkConf)
	.getOrCreate()

	val ordersDf = spark.read.format("csv")
	.option("header", true)
	//.option("inferSchema", true)
	.option("path", "D:\\BIGDATA\\Spark\\Spark Data\\orders.csv")
	.load()

	import spark.implicits._


	def zipWithIndex(df:Dataset[Row], offset: Long = 1, indexName: String = "index") = {
			val dfWithPartitionId = df.withColumn("partition_id", spark_partition_id()).withColumn("inc_id", monotonically_increasing_id())

					val partitionOffsets = dfWithPartitionId
					.groupBy("partition_id")
					.agg(count(lit(1)) as "cnt", first("inc_id") as "inc_id")
					.orderBy("partition_id")
					.select(sum("cnt").over(Window.orderBy("partition_id")) - col("cnt") - col("inc_id") + lit(offset) as "cnt" )
					.collect()
					.map(_.getLong(0))
					.toArray

					dfWithPartitionId
					.withColumn("partition_offset", udf((partitionId: Int) => partitionOffsets(partitionId), LongType)(col("partition_id")))
					.withColumn(indexName, col("partition_offset") + col("inc_id"))
					.drop("partition_id", "partition_offset", "inc_id")
	}


	ordersDf.printSchema()

	val resultDf = zipWithIndex(ordersDf, 0, "Index").where('Index>2).drop("Index")

	/*ordersDf.withColumn("Index", monotonically_increasing_id)
 .filter('Index>2)
 .drop("Index")*/


	resultDf.explain(true)

	resultDf.show();

	scala.io.StdIn.readLine();

}