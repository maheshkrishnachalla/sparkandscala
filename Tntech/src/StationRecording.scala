import org.apache.spark.SparkContext
import org.apache.log4j.Level
import org.apache.log4j.Logger


object StationRecording extends App{
  
  def recording(lines:String)={
    val line = lines.split(",")
    val stationId = line(0)
    val readingType = line(2)
    val tempRecorded = line(3).toInt
      (stationId,readingType,tempRecorded)
  }
  
  Logger.getLogger("org").setLevel(Level.ERROR)

	val sc = new SparkContext("local[*]","FriendsByAge")

	val input = sc.textFile("D:\\BIGDATA\\Spark\\temp-data.csv")
	
  val filtered = input.filter(x=>recording(x)._2.equalsIgnoreCase("TMIN"))
  
  val mapped = filtered.map(x=>(recording(x)._1,recording(x)._3))
  
  val minTemp = mapped.groupByKey().collect()
  
  for(i<-minTemp){
    println(i._1,i._2)
    println(i._1,i._2.min)
  }
 
  
}