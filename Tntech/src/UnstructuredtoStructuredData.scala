import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.log4j.Level
import org.apache.log4j.Logger


object UnstructuredtoStructuredData extends App{
  
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  val myregex = """^(\S+) (\S+)\t(\S+)\.(\S+)""".r
  
  case class Orders(order_id:Int,customer_id:Int,order_status:String)
  
  def parser(line:String)={
    line match{
      case myregex(order_id,date,customer_id,order_status)=>
        Orders(order_id.toInt,customer_id.toInt,order_status)
    }
  }
  
  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.Name","My first application")
  sparkConf.set("spark.master", "local[2]")
  
  
  val spark = SparkSession.builder()
  .config(sparkConf)
  .getOrCreate()
  
  val lines = spark.sparkContext.textFile("D:\\BIGDATA\\Spark\\Spark Data\\orders.csv")
  
  import spark.implicits._
  
  val orderDS = lines.map(parser).toDS().cache()
  
  orderDS.printSchema()
  
  orderDS.select("order_id").show()
  
  orderDS.groupBy("order_status").count().show()
  
  scala.io.StdIn.readLine()
  spark.stop()
  
  
  
}