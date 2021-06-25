import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.log4j.Level
import org.apache.log4j.Logger
import javax.swing.DefaultRowSorter.Row


object Broadcastingdata extends App{

  Logger.getLogger("org").setLevel(Level.ERROR)

	val sparkConf = new SparkConf()
	sparkConf.set("spark.app.Name","Avro File Formats")
	sparkConf.set("spark.master", "local[2]")

	val spark = SparkSession.builder()
	.config(sparkConf)
	.getOrCreate()
	
	val states = Map(("NY","Newyork"),("CA","California"),("FL","Florida"))
	
	val countries = Map(("USA","United States of America"),("IN","India"))
	
	val broadcastStates = spark.sparkContext.broadcast(states)
	
	val broadcastCountries = spark.sparkContext.broadcast(countries)
	
	val data = Seq(("James","Smith","USA","CA"),("Micheal","ronald","USA","NY"),
	    ("Robert","Williams","USA","CA"),("Maria","Jones","USA","FL"))
	    
	    
	 val columns = Seq("firstname","lastname","country","state")
	 
	 import spark.implicits._
	 
	 val df = data.toDF(columns:_*)
	 
	 val df2 = df.map(row => {
	   val country = row.getString(2)
	   val state = row.getString(3)
	     
	   val fullcountryName = broadcastCountries.value.get(country).get
	   
	   val fullstateName = broadcastStates.value.get(state).get
	   
	   (row.getString(0),row.getString(1),fullcountryName,fullstateName)
 
	 }).toDF(columns:_*)
	 
	 
	df2.show(false)
	
	scala.io.StdIn.readLine();

}