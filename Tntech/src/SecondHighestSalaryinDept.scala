import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.SaveMode
import org.apache.spark.sql.functions._

object SecondHighestSalaryinDept extends App{
  
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  val sparkConf = new SparkConf()
  sparkConf.set("spark.appName","Second Highesh Salary from Dept")
  sparkConf.set("spark.master","local[2]")
  
  val spark = SparkSession.builder()
  .config(sparkConf)
  .getOrCreate()
  
  sparkConf.getAll.foreach(println)
  
  import spark.implicits._
  
  val df = spark.read.option("header", true).option("inferSchema", true)
  .csv("D:\\BIGDATA\\Spark\\Emp_dept.csv")
  
  
  val df2 = df.withColumn("salary", regexp_replace(df.col("salary"), "[^0-9]", ""))
  
  val df3 = df2.selectExpr("seq","name","cast(salary as int) salary","dept")
  
  df3.printSchema()
  
  df3.createOrReplaceTempView("empdept")
  
  
  val emp = spark.sql("select * from (select name,salary,dept,"+
      " dense_rank() over (partition by dept order by salary desc) as rank "+
      " from empdept) tmp where rank = 2 order by salary desc").drop("rank")
  
  
  emp.show()
  
  /*df.write.format("avro")
  .mode(SaveMode.Overwrite)
  .option("maxRecordsPerFile", 1000)
  .option("path", "D:\\BIGDATA\\Spark\\avro_Emp_data")
  .save()*/
  
  scala.io.StdIn.readLine()
  
}