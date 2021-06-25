import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.lit


object DataframeMaskData extends App{
  
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.name","Dataframe Mask Data")
  sparkConf.set("spark.master","local[2]")
  
  val spark = SparkSession.builder()
  .config(sparkConf)
  .getOrCreate()
  
  val data = Seq((1,"Vinmat",57738,"California"),
      (2,"Seanpro",93637,"Newyork"),
      (3,"Niedany",78543,"Sanfrancisco"),
      (4,"Wafiele",67548,"Chicago"))
      
   import spark.implicits._  
   val df = data.toDF("id","name","salary","address")
   
   val maskedDf = df.withColumn("name", lit("***Masked***"))
   .withColumn("salary", lit("***Masked***"))
   
   
   maskedDf.show()
   
   scala.io.StdIn.readLine()
}