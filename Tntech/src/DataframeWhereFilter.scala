import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.Row
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.types.StringType
import org.apache.spark.sql.types.ArrayType
import org.apache.spark.sql.functions.array_contains
import org.apache.spark.sql.functions.col
import org.apache.spark.sql.functions.explode

object DataframeWhereFilter extends App{
  
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.Name","Dataframe Where Filter")
  sparkConf.set("spark.master","local[*]")
  
  val spark = SparkSession.builder()
  .config(sparkConf)
  .getOrCreate()
  
  val arrayStructureData = Seq(Row(Row("James","","smith"),
      List("Java","scala","c++"),"OH","M"),
      Row(Row("Anna","Rose",""),List("spark","Java","c++"),"NY","F"),
      Row(Row("Julia","","Williams"),List("Csharp","VB"),"OH","F"),
      Row(Row("Maria","Anne","Jones"),List("Csharp","VB"),"NY","M"),
      Row(Row("Jen","Mary","Brown"),List("Csharp","VB"),"NY","M"),
      Row(Row("Mike","Mary","Williams"),List("Python","VB"),"OH","M")
      )  
      
  val arrayStructureSchema = new StructType()
  .add("name",new StructType()
  .add("firstname",StringType)
  .add("middlename",StringType)
  .add("lastname",StringType))
  .add("languages",ArrayType(StringType))
  .add("state",StringType)
  .add("gender",StringType)
  
  import spark.implicits._
  
  val rdd = spark.sparkContext.parallelize(arrayStructureData)
  
  val df = spark.createDataFrame(rdd,arrayStructureSchema)
  
  df.printSchema()
  
  //val df2 = df.filter(df("state") === "OH")
  
 // val df3 = df2.where('gender === "M")
  
  //val df4 = df.filter(array_contains(col("languages"),"Java"))
  
  //val df5 = df.where("name.lastname == 'Williams'")

  val df6 = df.withColumn("languages", explode('languages))
  
  df6.show(false)
      
           
}


