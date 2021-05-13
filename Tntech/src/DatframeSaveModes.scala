import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.sql.SaveMode


object DatframeSaveModes extends App{
  
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.Name","My first application")
  sparkConf.set("spark.master", "local[2]")
  
  
  val spark = SparkSession.builder()
  .config(sparkConf)
  .getOrCreate()
  
  val ordersDf  = spark.read
  .option("header", true)
  .option("inferSchema",true)
  .csv("D:\\BIGDATA\\Spark\\Spark Data\\orders.csv")
  
  println("ordersDf has partitions : "+ordersDf.rdd.getNumPartitions)
  
  val ordersRep = ordersDf.repartition(4)
  
  println("ordersRep has partitions : "+ordersRep.rdd.getNumPartitions)
  
  ordersRep.write
  .format("avro")  // by default avro file format is not supported,
                  //need to add avro 2.4.42.11 jar
 .partitionBy("order_status")
  .mode(SaveMode.Overwrite)
  .option("maxRecordsPerFile",2000)
  .option("path","D:\\BIGDATA\\Spark\\Spark Data\\newfolder1")
  .save()
  
}