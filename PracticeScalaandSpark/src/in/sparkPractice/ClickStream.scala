package in.sparkPractice

import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object ClickStream extends App{
  
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  //setting log level
  val sparkConf = new SparkConf()
  
  //setting spark conf
  sparkConf.set("spark.app.name", "Click Stream")
  sparkConf.set("spark.master", "local[2]")
  
  //setting spark session
  val spark = SparkSession.builder()
  .config(sparkConf)
  .getOrCreate()
  
  
}