import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.catalyst.expressions
import org.apache.spark.sql.functions.{row_number,rank,
  dense_rank,percent_rank,ntile,cume_dist,lag,lead,avg,sum,max,min}


object DataframeWindowFunctions extends App{
  
  	Logger.getLogger("org").setLevel(Level.ERROR)
  	
  	val sparkConf = new SparkConf()
  	sparkConf.set("spark.app.Name","Window functions")
  	sparkConf.set("spark.master","local[2]")
  	
  	val spark = SparkSession.builder()
  	.config(sparkConf)
  	.getOrCreate()
  	
  	import spark.implicits._
  	
  	val empData = Seq(("James", "Sales", 3000),
    ("Michael", "Sales", 4600),
    ("Robert", "Sales", 4100),
    ("Maria", "Finance", 3000),
    ("James", "Sales", 3000),
    ("Scott", "Finance", 3300),
    ("Jen", "Finance", 3900),
    ("Jeff", "Marketing", 3000),
    ("Kumar", "Marketing", 2000),
    ("Saif", "Sales", 4100))
    
    
    val df = empData.toDF("empName","department","salary")
    
    //df.show()
  	
    // window row_number
    
    val windowSpec = Window.partitionBy("department").orderBy("salary")
    val rowNum_df = df.withColumn("rowNum", row_number.over(windowSpec))
    
    /*rowNum_df.show()
    
    val rank_df = df.withColumn("rank",rank().over(windowSpec))
    
    rank_df.show()
    
    val denserank_df = df.withColumn("denserank", dense_rank().over(windowSpec))
  	
    denserank_df.show() 
    
    val percentrank_df = df.withColumn("percentrank", percent_rank().over(windowSpec))
    
    percentrank_df.show()
    
    
    val ntile_df = df.withColumn("ntile", ntile(2).over(windowSpec))
    
    ntile_df.show()
    
    val cum_df = df.withColumn("cume_dist", cume_dist().over(windowSpec))
    
    cum_df.show()
    
    val lag_df = df.withColumn("lag", lag("salary", 2).over(windowSpec))
    
    lag_df.show()
    
    val lead_df = df.withColumn("lead", lead("salary", 2).over(windowSpec))
    
    lead_df.show() */
    
    val windowSpecAgg = Window.partitionBy("department").orderBy("salary")
    
    val addDf = df.withColumn("rowNum", row_number().over(windowSpecAgg))
    .withColumn("avg", avg("salary").over(windowSpecAgg))
    .withColumn("sum", sum("salary").over(windowSpecAgg))
    .withColumn("max", max("salary").over(windowSpecAgg))
    .withColumn("min", min("salary").over(windowSpecAgg))
    .where('rowNum===1).select("department","avg","sum","max","min")
    .show()
     
    
    scala.io.StdIn.readLine()
    
}