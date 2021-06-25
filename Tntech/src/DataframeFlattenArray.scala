import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.Row
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.types.StringType
import org.apache.spark.sql.types.ArrayType
import org.apache.spark.sql.functions.flatten


object DataframeFlattenArray extends App{

  Logger.getLogger("org").setLevel(Level.ERROR)
  
  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.name", "Dataframe Flatten Array")
  sparkConf.set("spark.master","local[2]")
  
  val spark = SparkSession.builder()
  .config(sparkConf)
  .getOrCreate()
  
  val arrayData = Seq(
      Row("James",List(List("Java","Scala","C++"),List("Spark","Java"))),
      Row("Micheal",List(List("Spark","Java","C++"),List("Spark","Java"))),
      Row("Robert",List(List("C++","VB"),List("Spark","Python")))
      )
    
    val arraySchema = new StructType().add("name",StringType)
    .add("subjects",ArrayType(ArrayType(StringType)))
      
    import spark.implicits._
    
    val df = spark.createDataFrame(spark.sparkContext.parallelize(arrayData), arraySchema)
    
    df.printSchema()
    
   // df.show()
    
    val flatDf = df.select($"name", flatten($"subjects"))
    
    flatDf.show(false)
    
    scala.io.StdIn.readLine()
    
}