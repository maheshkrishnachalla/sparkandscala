import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.Row
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.types.StringType
import org.apache.spark.sql.types.IntegerType


object DataframeCollectandCollectAsList extends App{
  
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.name", "Dataframe Collect and CollectAsList")
  sparkConf.set("spark.master", "local[2]")
  
  val spark = SparkSession.builder()
  .config(sparkConf)
  .getOrCreate()
  
  
  val data = Seq(Row(Row("James ","","Smith"),"36636","M",3000),
    Row(Row("Michael ","Rose",""),"40288","M",4000),
    Row(Row("Robert ","","Williams"),"42114","M",4000),
    Row(Row("Maria ","Anne","Jones"),"39192","F",4000),
    Row(Row("Jen","Mary","Brown"),"","F",1000))
    
    
    val schema = new StructType()
  .add("name", new StructType()
  .add("firstname",StringType)
  .add("middlename",StringType)
  .add("lastname",StringType))
  .add("id",StringType)
  .add("gender",StringType)
  .add("salary",IntegerType)
  
  
  val df = spark.createDataFrame(spark.sparkContext.parallelize(data), schema)
  
  //df.printSchema()
  
  val collectList = df.collectAsList()
  val collect = df.collect()
  
  collect.foreach(row =>
    {
      val salary = row.get(3)
      println(salary)
    }
      )
      
   collect.foreach(row =>
     {
       val salary = row.get(3)
       val fullName:Row = row.getStruct(0)
       val firstName = fullName.getString(0)
       val middleName = fullName.get(1).toString()
       val lastName = fullName.getAs[String]("lastname")
       println(firstName+","+middleName+","+lastName+","+salary)
       
     }
     )
  
    println(collectList) 
    
    val name = df.select("name").collect()
    
    name.foreach(println)
   
  //df.show(false)
  
  scala.io.StdIn.readLine()
}