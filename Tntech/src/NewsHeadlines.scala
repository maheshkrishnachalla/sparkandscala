import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import scala.io.Source


object NewsHeadlines extends App{
  
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  def boringWords():Set[String]={
    var boringwords:Set[String] = Set()
    val lines = Source.fromFile("D:\\BIGDATA\\Spark\\Spark Data\\boringwords.txt")
    .getLines()
    
    for(line <- lines){
      boringwords+=line
    }
     boringwords
  }
  
  val sparkconf  = new SparkConf()
  sparkconf.set("spark.app.Name", "News Headlines")
  sparkconf.set("spark.master","local[2]")
  
  
  val spark = SparkSession.builder()
  .config(sparkconf)
  .getOrCreate()
  
  var nameset = spark.sparkContext.broadcast(boringWords)
  
  val newsRdd =  spark.read.format("csv")
  .option("header", true)
  .option("path","D:\\BIGDATA\\Spark\\abcnews-date-text.csv")
  .load()
  
  import spark.implicits._
  
  val newsDf = newsRdd.toDF().drop("publish_date");
  
  
  val mapDf = newsDf.rdd.map(x=>x.mkString)
  
  
  val fmapped = mapDf.flatMap(x=>x.split(" "))
  
  val mapped  = fmapped.map(x=>(x,1))
  
  //val filtered_rdd =finalMapped.filter(x=> !nameSet.value(x._1))
  
  val filtered = mapped.filter(x => !nameset.value(x._1))
  
  val result = filtered.reduceByKey((x,y)=>x+y).sortBy(x=>x._2,false)
  
  val cols = Seq("News_words","count")
  
  val resultDf = result.toDF(cols:_*)
  
  resultDf.show(50)
  
  //result.take(50).foreach(println)
  
  
  
  
  scala.io.StdIn.readLine()
  
  
}