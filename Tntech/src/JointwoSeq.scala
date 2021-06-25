import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession


object JointwoSeq extends App {
  
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  val sparkConf = new SparkConf()
  sparkConf.set("spark.appName", "join two Seq")
  sparkConf.set("spark.master","local[*]")
  
  val spark = SparkSession.builder()
  .config(sparkConf)
  .getOrCreate()
  
  import spark.implicits._
  
  val sq1 = spark.sparkContext.parallelize(Seq(List((1,"a"),(2,"b"),(3,"c"),(4,"d"))))
  
  val sq2 = spark.sparkContext.parallelize(Seq(List(("a","Good"),("c","Well"))))
  
  val df1 = sq1.toDF();
  
  val df2 = sq2.toDF();
  
  val joinDf = df1.crossJoin(df2)
  
  joinDf.show(true)
  
  scala.io.StdIn.readLine()
  
  
}