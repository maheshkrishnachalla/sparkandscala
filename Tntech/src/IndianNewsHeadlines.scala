import org.apache.log4j.Level
import org.apache.log4j.Logger
import scala.io.Source
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql.SaveMode

object IndianNewsHeadlines extends App{
  
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  def boringWords():Set[String]={
    var boringwords:Set[String] =  Set()
    val lines = Source.fromFile("D:\\BIGDATA\\Spark\\Spark Data\\boringwords.txt").getLines()
    
    for(line <- lines){
      boringwords += line.toLowerCase()
    }
    
    return boringwords   
    }
  
   val sparkConf = new SparkConf()
   sparkConf.set("spark.appName", "Indian News Headlines")
   sparkConf.set("spark.master","local[2]")
   
   val spark = SparkSession.builder()
   .config(sparkConf)
   .getOrCreate()
   
   var wordSet = spark.sparkContext.broadcast(boringWords)
   
   val loadNewsHeadlines = spark.read.format("csv")
   .option("header", true)
   .option("path", "D:\\BIGDATA\\Spark\\india-news-headlines.csv")
   .load
   
   
    import spark.implicits._
    
   val headlines = loadNewsHeadlines.drop("publish_date","headline_category")
   
   val mapHeadLines = headlines.rdd.map(x=>x.mkString.toLowerCase())
   
   val flatmapHeadlines = mapHeadLines.flatMap(x=>x.split(" "))
   
   val mapHeadlineswithValue = flatmapHeadlines.map(x=>(x.replaceAll("[^a-zA-Z]", ""),1))
   
   val filteredHeadLines = mapHeadlineswithValue.filter(x=> !wordSet.value(x._1))
   .filter(x=> x._1.length()>2)
   
   val result = filteredHeadLines.reduceByKey((x,y)=>x+y).sortBy(x=>x._2, false)
   
   val cols = Seq("Indian_NewsHeadlines_words","count")
   
   val resultDf = result.toDF(cols:_*)
   
   resultDf.show(100);
   
   
   scala.io.StdIn.readLine() 
  
}