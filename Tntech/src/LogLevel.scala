import org.apache.spark.SparkContext
import org.apache.log4j.Level
import org.apache.log4j.Logger


object LogLevel extends App{

	Logger.getLogger("org").setLevel(Level.ERROR)

	val sc=new SparkContext("local[*]","LogLevel")

	val mylist = List("WARN: Tuesday 4 September 0405", 
			"ERROR: Tuesday 4 September 0408", 
			"ERROR: Tuesday 4 September 0408",
			"ERROR: Tuesday 4 September 0408", 
			"ERROR: Tuesday 4 September 0408", 
			"ERROR: Tuesday 4 September 0408") 
			
			
		val originalLogsRdd = sc.parallelize(mylist)
		println(originalLogsRdd.getNumPartitions)
		
		val pairRdd = originalLogsRdd.map(x=>(x.split(":")(0),1))
		
		val countRdd = pairRdd.reduceByKey((x,y)=>x+y)
		
		countRdd.collect().foreach(println)


}