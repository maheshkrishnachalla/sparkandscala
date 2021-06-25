import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.types.StructField
import org.apache.spark.sql.types.IntegerType
import org.apache.spark.sql.types.StringType
import org.apache.spark.sql.types.DoubleType



object Employeetable extends App{

	Logger.getLogger("org").setLevel(Level.ERROR)

	val sparkConf = new SparkConf()
	sparkConf.set("spark.app.Name","employee table")
	sparkConf.set("spark.master", "local[2]")

	val spark = SparkSession.builder()
	.config(sparkConf)
	.getOrCreate()

	// created schema for the employee
	/*val empSchema = StructType(List(
			StructField("id",IntegerType),
			StructField("name",StringType),
			StructField("salary",DoubleType)
			)
			)*/

	import spark.implicits._

	// Loading the CSV file and applying schema on the data
	val df = spark.read.format("csv")
	.option("header", true)
	//.schema(empSchema)
	.option("path", "D:\\BIGDATA\\Spark\\empdata.csv")
	.load()

	
	//val df = spark.sparkContext.textFile("D:\\BIGDATA\\Spark\\empdata.csv")
	df.printSchema()
	
	df.show(4,false)

	
	// changed dataframe to rdd
	val mapped = df.rdd.map(x => (x.get(0).toString(),x.get(1).toString(),x.get(2).toString()))

	// apply the requirement logic in the map
	val resultmap = mapped.map(x=> {
	  val id = x._1.toInt+1
	  val name = x._2.toString().toUpperCase()
	  val salary = x._3.toDouble+x._3.toDouble*0.1
	  val sal = salary.round
	 
	  (id,name, sal)
	}
	)//.sortBy(x=>x._3,false)

	val col = Seq("id","emp_name","salary")

	val result = resultmap.toDF(col:_*)

	result.show(4,false)
	
	scala.io.StdIn.readLine()

}