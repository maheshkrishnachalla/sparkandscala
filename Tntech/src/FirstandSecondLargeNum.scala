

object FirstandSecondLargeNum extends App{

	def array(arr:Array[Int])={
			val len = arr.length
					var temp =0
					for(i <- 0 to len-1){
						if(arr(0)<arr(i)){
							temp = arr(0)
									arr(0)= arr(i)
									arr(i) =temp
						}
					}
			for(i <- 1 to len-1){
				if(arr(1)<arr(i)){
					temp = arr(1)
							arr(1)= arr(i)
							arr(i) =temp
				}
			}

			println("Largest Number = "+arr(0))

			println("Second Largest Number = "+arr(1))
	}

	def array2(arr:Array[Int])={
			val len = arr.length
					var temp =0
					var s =arr(0)
					var f =arr(1)
					var x= 0
					for(i <- 2 to len-1){
					  x=arr(i)
						if(x>f){
							f=x	
									s=f
						}
						if(x>s && x<f){
							s=arr(i)
						}
						if(s>f){
							temp = s
									s =f
									f =temp
						}
					}

			println("Largest Number = "+arr(0))

			println("Second Largest Number = "+arr(1))
	}

	val r =  (1 to 100000000).toArray

			val ar = Array(1,4,2,6,3,7,92,5,89,11,41,22,62,1133,27,19,65,81,54,24,26,1,4,2,6,3,7,92,5,89,11,41,22,62,33,27,19,65,81,54,24,26,1,4,2,6,3,7,92,5,89,11,41,22,62,33,27,19,65,81,54,24,26
					,999,586,394,55,2,33,4522,45,55,2278,64,1,1,4,2,566,3,7,92,5,89,11,41,22,62,33,27,19,65,81,54,24,26,1,4,2,6,3,7,92,5,89,11,41,22,62,33,27,19,65,81,54,24,26,1,4,2,6,3,7,92,5,89,11,41,22,62,33,27,19,65,81,54,24,26
					,991,586,394,55,2,33,22,45,55,4378,64,1,1,4,2,6,3,7,92,5,89,11,41,22,62,1133,27,19,65,81,54,24,26,1,4,2,6,3,7,92,5,89,11,41,22,62,33,27,19,65,81,54,24,26,1,4,2,6,3,7,92,5,89,11,41,22,62,33,27,19,65,81,54,24,26
					,999,586,394,55,2,33,4522,45,55,2278,64,1,1,4,2,566,3,7,92,5,89,11,41,22,62,33,27,19,65,81,54,24,26,1,4,2,6,3,7,92,5,89,11,41,22,62,33,27,19,65,81,54,24,26,1,4,2,6,3,7,92,5,89,11,41,22,62,33,27,19,65,81,54,24,26
					,991,586,394,55,2,33,22,45,55,5378,64,1,1,4,2,6,3,7,92,5,89,11,41,22,62,1133,27,19,65,81,54,24,26,1,4,2,6,3,7,92,5,89,11,41,22,62,33,27,19,65,81,54,24,26,1,4,2,6,3,7,92,5,89,11,41,22,62,33,27,19,65,81,54,24,26
					,999,586,394,55,2,33,3522,45,55,2278,64,1,1,4,2,566,3,7,92,5,89,11,41,22,62,33,27,19,65,81,54,24,26,1,4,2,6,3,7,92,5,89,11,41,22,62,33,27,19,65,81,54,24,26,1,4,2,6,3,7,92,5,89,11,41,22,62,33,27,19,65,81,54,24,26
					,991,586,394,55,2,33,22,45,55,4378,64,1)

			val t1 = System.nanoTime()
			array(ar)
			val t2 = System.nanoTime()
			println("Elapsed time "+(t2-t1)/1000000+"ns")


			val t3 = System.nanoTime()
			array2(ar)
			val t4 = System.nanoTime()
			println("Elapsed time "+(t4-t3)/1000000+"ns")


}