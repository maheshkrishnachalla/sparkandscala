import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.log4j.Level
import org.apache.log4j.Logger


object DataframeLoggingLevel extends App{
case class Logging(level:String,datetime:String)  

Logger.getLogger("org").setLevel(Level.ERROR)

val sparkconf = new SparkConf()
sparkconf.set("spark.app,nadeptIdme", "Cricket Analysis")
sparkconf.set("spark.master","local[2]")

val spark = SparkSession.builder()
.config(sparkconf)
.getOrCreate()

val myList =List("DEBUG,2015-2-6 16:24:07",
		"WARN,2016-7-26 18:54:43",
		"INFO,2012-10-18 14:35:19",
		"DEBUG,2012-4-26 14:26:50",
		"DEBUG,2013-9-28 20:27:13",
		"INFO,2017-8-20 13:17:27",
		"INFO,2015-4-13 09:28:17",
		"DEBUG,2015-7-17 00:49:27",
		"DEBUG,2014-7-26 02:33:09")

def mapper(line:String):Logging = {
		val fields = line.split(",")
				val log:Logging=Logging(fields(0),fields(1))
				return log
}

/*val rdd1 = spark.sparkContext.parallelize(myList)
val rdd2 = rdd1.map(mapper)

	import spark.implicits._

	val df = rdd2.toDF()

	df.createOrReplaceTempView("LoggingTable")*/

	//spark.sql("select * from LoggingTable").show()

	//spark.sql("select level,collect_list(datetime) from LoggingTable group by level order by level")
	//.show(false)

	//spark.sql("select level,count(datetime) from LoggingTable group by level order by level")
	//.show(false)
	
	//val df2 = spark.sql("select level,date_format(datetime,'MMMM') as month from LoggingTable")
	//.show()
	
	//df2.createOrReplaceTempView("newLoggingTable")
	
	//spark.sql("select level,month,count(1) from newLoggingTable group by level,month")
	//.show()
	
	
	val df3 = spark.read
	.format("csv")
	.option("header", true)
	.option("path","D:\\BIGDATA\\Spark\\Dataframe and Dataset\\biglog.txt")
	.load()
	
	df3.createOrReplaceTempView("NewLoggingTable")
	
	/*val results = spark.sql("""select level,date_format(datetime,'MMMM') as month, 
	  count(1) as total from NewLoggingTable group by level, month order by month""")
	.show()*/
	
	/*val results1 = spark.sql("""select level,date_format(datetime,'MMMM') as month, 
	  cast(first(date_format(datetime,'M')) as int) as monthnum,
	  count(1) as total from NewLoggingTable 
	   group by level, month order by monthnum, level""")
	
	   val results1 = results.drop("monthnum")
	
	   results1.show(60)*/
	   
	val  columns = List("January","February","March","April","May",
	    "June","July","August","September","October","November","December")
	   
	   
	   val results2 = spark.sql("""select level,date_format(datetime,'MMMM') as month 
	   from NewLoggingTable""").groupBy("level").pivot("month",columns).count()
	  
	  
	  results2.show(100)
	
	  
	   
	   
//	results.createOrReplaceTempView("resultsTable")
	
	

}