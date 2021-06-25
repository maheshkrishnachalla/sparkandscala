import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._


object DataframePivot extends App{
  
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.name", "Dataframe pivot")
  sparkConf.set("spark.master", "local[2]")
  
  val spark = SparkSession.builder()
  .config(sparkConf)
  .getOrCreate()
  
  val data = Seq(("Banana",1000,"USA"), ("Carrots",1500,"USA"), ("Beans",1600,"USA"),
      ("Orange",2000,"USA"),("Orange",2000,"USA"),("Banana",400,"China"),
      ("Carrots",1200,"China"),("Beans",1500,"China"),("Orange",4000,"China"),
      ("Banana",2000,"Canada"),("Carrots",2000,"Canada"),("Beans",2000,"Mexico"))
  
      
    import spark.implicits._
  
   val df = data.toDF("Product","Amount","Country")
   
   //df.show()
   
  // val pivotDf = df.groupBy("Product").pivot("Country").sum("Amount")
   
  // pivotDf.show()
   
   val countries = Seq("USA","China","Canada","Mexico")
   
   //val pivotdf2 = df.groupBy("Product").pivot("Country",countries).sum("Amount")
   
   //pivotdf2.show()
   
   
   val pivotdf3 = df.groupBy("Product", "Country").sum("Amount")
   .groupBy("Product").pivot("Country").sum("sum(Amount)")
   
   
   pivotdf3.show()
   
   
   val unPivot = pivotdf3
   .select($"Product", expr("stack(3,'Canada',Canada,'China',China,'Mexico',Mexico) as (Country,Total)"))
   .where("Total is not null")
   
   unPivot.show()
   
   scala.io.StdIn.readLine()
  
}