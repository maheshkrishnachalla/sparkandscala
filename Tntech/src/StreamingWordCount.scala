import org.apache.spark._

import org.apache.spark.streaming._
import org.apache.spark.streaming.StreamingContext._
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.sql.SparkSession


object StreamingWordCount extends App{

	Logger.getLogger("org").setLevel(Level.ERROR)

	val sparkConf = new SparkConf()
	sparkConf.set("spark.app.Name","Streaming Word Count")
	sparkConf.set("spark.master", "local[2]")


	val spark = SparkSession.builder()
	.config(sparkConf)
	.getOrCreate()

	val ssc = new StreamingContext(spark.sparkContext, Seconds(5))

	//lines is Dstream holding many rdds

	val lines = ssc.socketTextStream("localhost",9998)

	// words is a transformed dstream
	val words = lines.flatMap(x=>x.split(" "))

	val pairs = words.map(x => (x,1))

	val wordCounts = pairs.reduceByKey(_+_)

	wordCounts.print()

	ssc.start()
	
	ssc.awaitTermination()

}