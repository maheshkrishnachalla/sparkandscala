import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.StructField
import org.apache.spark.sql.types.IntegerType
import org.apache.spark.sql.types.StringType
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.Row
import org.apache.spark.sql.functions.when


object DataframeMissingDatainColumns extends App{
  
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.name", "Dataframe Missing Data in Columns")
  sparkConf.set("spark.master", "local[2]")
  
  val spark = SparkSession.builder()
  .config(sparkConf)
  .getOrCreate()
  
  val data = Seq(Row(1,"mangoes",66,"v432"),
Row(2,"mangoes",66,"v4632"),
Row(3,"mangoes",null,"v4312"),
Row(4,"mangoes",66,"v432"),
Row(5,"mangoes",66,null),
Row(6,"mangoes",null,null),
Row(7,"mangoes",null,"v256"),
Row(8,"mangoes",null,null),
Row(9,"mangoes",66,null),
Row(10,"mangoes",66,"v432")
  )
  
  val schema = List(StructField("id",IntegerType,false),
      StructField("name",StringType,false),
      StructField("qty",IntegerType,true),
      StructField("vendor_Id",StringType,true))
  
  import spark.implicits._
  
 val df = spark.createDataFrame(spark.sparkContext.parallelize(data),
     StructType(schema))
 
     
  val validData = df.filter('qty.isNotNull && 'vendor_Id.isNotNull)
  
  val invalidData = df.filter('qty.isNull || 'vendor_Id.isNull)
  .withColumn("Hold_reason", when('qty.isNull, "qty is missing")
      .otherwise(when('vendor_Id.isNull,"vendor_Id is missing")))
  
  
 validData.show(false)
 
 invalidData.select("id","name","Hold_reason").show(false)
 
 scala.io.StdIn.readLine()
}