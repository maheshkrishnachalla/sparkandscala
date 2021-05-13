import org.apache.spark.SparkContext
import org.apache.log4j.Level
import org.apache.log4j.Logger


object TopRatedMovies extends App{
  
  Logger.getLogger("org").setLevel(Level.ERROR)

	val sc=new SparkContext("local[*]","TopRatedMovies")

  val ratingsRdd = sc.textFile("D:\\BIGDATA\\Spark\\Moviesdata\\ratings.dat")
  
  val mapRdd = ratingsRdd.map(x=>{
    val col = x.split("::")
    (col(1),col(2))
  })

  val newMapRdd = mapRdd.mapValues(x=>(x.toFloat,1.0F))
  
  val reducedRdd = newMapRdd.reduceByKey((x,y)=>(x._1+y._1,x._2+y._2))
  
  val filteredRdd = reducedRdd.filter(x=>x._2._2>1000)
  
  val ratingsProcessed = filteredRdd.mapValues(x=>x._1/x._2).filter(x=>x._2>4.0) 
  
  
  val moviesRdd = sc.textFile("D:\\BIGDATA\\Spark\\Moviesdata\\movies.dat")
  
  val moviesMapped = moviesRdd.map(x=>{
    val fields = x.split("::")
    (fields(0),fields(1))
  })
  
  val topMovies = moviesMapped.join(ratingsProcessed).map(x=>x._2._1)  
  
  
  topMovies.collect().foreach(println)
  
  scala.io.StdIn.readLine()
  
}