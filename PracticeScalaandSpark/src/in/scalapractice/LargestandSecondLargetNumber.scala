package in.scalapractice

object LargestandSecondLargetNumber {
  
   def main(args:Array[String]){
     
     //method 1 time complexity is n*n 
     val t1 = System.nanoTime()
     var firstArray:Array[Int]= Array(1,4,2,6,3,7,92,5,89,11,41,22,62,33,27,19,65,81,54,24,26,1,4,2,6,3,7,92,5,89,11,41,22,62,33,27,19,65,81,54,24,26,1,4,2,6,3,7,92,5,89,11,41,22,62,33,27,19,65,81,54,24,26
         ,999,586,394,55,2,33,22,45,55,78,64,1,1,4,2,6,3,7,92,5,89,11,41,22,62,33,27,19,65,81,54,24,26,1,4,2,6,3,7,92,5,89,11,41,22,62,33,27,19,65,81,54,24,26,1,4,2,6,3,7,92,5,89,11,41,22,62,33,27,19,65,81,54,24,26
         ,991,586,394,55,2,33,22,45,55,78,64,1)
     for(i<-0 to firstArray.length-1){
       for(j<- i+1 to firstArray.length-1){
       if(firstArray(i)>firstArray(j)){
         var temp = firstArray(i)
         firstArray(i) = firstArray(j)
         firstArray(j) = temp
       }
       }
     }
     println(firstArray(firstArray.length-1),firstArray(firstArray.length-2))
    println("lenght = "+firstArray.length)
    val t2 = System.nanoTime()
    println("Elapsed time "+(t2-t1)/1000000+"ns")
    
    // method 2 time complexity is n+n =2n
    val t3 = System.nanoTime()
     var secondArray:Array[Int]= Array(1,4,2,6,3,7,92,5,89,11,41,22,62,33,27,19,65,81,54,24,26,1,4,2,6,3,7,92,5,89,11,41,22,62,33,27,19,65,81,54,24,26,1,4,2,6,3,7,92,5,89,11,41,22,62,33,27,19,65,81,54,24,26
         ,999,586,394,55,2,33,22,45,55,78,64,1,1,4,2,6,3,7,92,5,89,11,41,22,62,33,27,19,65,81,54,24,26,1,4,2,6,3,7,92,5,89,11,41,22,62,33,27,19,65,81,54,24,26,1,4,2,6,3,7,92,5,89,11,41,22,62,33,27,19,65,81,54,24,26
         ,991,586,394,55,2,33,22,45,55,78,64,1)
    var temp = 0
     for(i<-0 to secondArray.length-1){
       if(secondArray(0)<secondArray(i)){
         temp = secondArray(i) 
         secondArray(i) = secondArray(0)
         secondArray(0) = temp
       }
       for(j<-1 to secondArray.length-2){
       if(secondArray(1)<secondArray(j)){
         temp = secondArray(j) 
         secondArray(j) = secondArray(1)
         secondArray(1) = temp
       }
     }
       }
     println(secondArray(0),secondArray(1))
     println("lenght = "+secondArray.length)
     val t4 = System.nanoTime()
     println("Elapsed time "+(t4-t3)/1000000+"ns")
     
   }
}