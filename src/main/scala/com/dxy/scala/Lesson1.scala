package com.dxy.scala

import scala.collection.immutable

/** @Author kiwi
 * @Date 2022/4/20 16:17
 * @Description TODO
 */
object Lesson1 {
  def main(args: Array[String]): Unit = {
    var a=0
    if(a<=0) {
      println(s"$a<=0")
    } else {
      println(s"$a>0")
    }
  }

  // 使用val也不行 b必须是变量
  var b = 0
  while(b<10) {
    println(b)
    // scala中 b++不可用  可以用 b=b+1 b+=1
    b+=1
  }

  println("========================================")
  // for scala只支持 增强for循环
  // 起始为1 步长为2  终值为10  to包含10  util不包含10
   val seq: Range.Inclusive = 1 to (10,2)
  println(seq)

   val a: Range = 1 until(10,1)
    for (i <- a if(i%2 == 0)){
      println(i)
    }

  println("----==================")
//  for (i <- 1 to 9) {
//    for (j <- 1 to 9) {
//      if (j <= i) print(s"$i * $j = ${i*j} \t")
//      if (j == i) println()
//    }
//  }
  println("----=========简化版双层for=========")
  var num = 0
  // 双重for循环，并且j<=i的时候才会进for循环  比如当i=1时  j=1才能进来，其他情况j不会进来
  for (i <- 1 to 9;j <- 1 to 9 if j <= i) {
    num += 1
      if (j <= i) print(s"$i * $j = ${i*j} \t")
      if (j == i) println()
  }
  println(num)

  println("==============yeild 收集for循环的值并做函数式处理=================")
  val seqss: immutable.IndexedSeq[Int] = for ( i <- 1 to 10) yield {
    var x = 8
    i + x
  }
  println(seqss)

  for (i<-seqss) {
    println(i)
  }
}
