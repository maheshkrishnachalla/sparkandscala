import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.sql.SparkSession
import org.apache.spark.streaming._
import org.apache.spark.streaming.StreamingContext._
import org.apache.spark.SparkConf
import org.apache.spark.sql.types.ArrayType
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.functions._
import org.apache.spark.sql.functions



object MultiLineJsonParser extends App{
  
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.Name","Multi Line Json Parser")
  sparkConf.set("spark.master","local[2]")
  
  val spark = SparkSession.builder()
  .config(sparkConf)
  .getOrCreate()
  
  val readDf = spark.read
  .option("multiline", true)
  .option("mode", "permissive")
  .json("C:\\Users\\Admin\\Desktop\\MultilineJsonParser.json")
  
    import spark.implicits._
  // explode Array DF
  
    //loadDf.createOrReplaceTempView("customers")
    readDf.write.parquet("C:\\Users\\Admin\\Desktop\\multiline.parquet")
    
   val  parquetDf = spark.read.parquet("C:\\Users\\Admin\\Desktop\\multiline.parquet")
    
   
   parquetDf.printSchema()
   
   parquetDf.createOrReplaceTempView("parquetFile")
   
   val resultDf = spark.sql("select * from parquetFile")
   
   val x = resultDf.columns.size;
   
   println("colums" + x)
   
   
   
   
   
   
 //   val resultDf = loadDf.select("address.*", "invoiceItem.*").drop("address","invoiceItem")
  
   
   //loadDf.show(false)
      
      
    
    
  
 /* val loadDf2 = spark.sparkContext.wholeTextFiles("C:\\Users\\Admin\\Desktop\\MultilineJsonParser.json")
  .map(x=>x._2)
  
  val parsedJson = spark.read.json(loadDf2)
  
  parsedJson.show(false)
 
  
  */
  //loadDf.show()
  

  
}