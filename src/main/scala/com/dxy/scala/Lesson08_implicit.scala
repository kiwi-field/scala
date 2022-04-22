package com.dxy.scala

import java.util

object Lesson08_implicit {


  def main(args: Array[String]): Unit = {


    val list = new util.LinkedList[Int]()
    list.add(1)
    list.add(2)
    list.add(3)


    val listArray = new util.ArrayList[Int]()
    listArray.add(1)
    listArray.add(2)
    listArray.add(3)

//    list.foreach(println)   //3个东西：  list数据集  foreach 遍历行为  println 处理函数


    def foreach[T](list:util.LinkedList[T], f:(T)=>Unit): Unit ={
      val iter: util.Iterator[T] = list.iterator()
      while(iter.hasNext) f(iter.next())
    }

    foreach(list,println)


//    val xx = new XXX(list)
//    xx.foreach(println)

    //隐式转换：  隐式转换方法
    implicit def sdfsdf[T](list:util.LinkedList[T]) ={
      val iter: util.Iterator[T] = list.iterator()
      new XXX(iter)
  }
//
//    implicit def sldkfjskldfj[T](list:java.util.ArrayList[T]) ={
//      val iter: util.Iterator[T] = list.iterator()
//      new XXX(iter)
//    }
//
    list.foreach(println)
//    listArray.foreach(println)

    //spark  RDD N方法 scala
    //隐式转换类
//    implicit  class KKK[T](list:util.LinkedList[T]){
//      def foreach( f:(T)=>Unit): Unit ={
//        val iter: util.Iterator[T] = list.iterator()
//        while(iter.hasNext) f(iter.next())
//      }
//    }
//    list.foreach(println) //必须先承认一件事情：  list有foreach方法吗？  肯定是没有的~！ 在java里这么写肯定报错。。

    //这些代码最终交给的是scala的编译器！
    /*
    1,scala编译器发现 list.foreach(println)  有bug
    2,去寻找有没有implicit  定义的方法，且方法的参数正好是list的类型！！！
    3,编译期：完成你曾经人类：
    //    val xx = new XXX(list)
//    xx.foreach(println)
  *，编译器帮你把代码改写了。。。！
     */


//    implicit val sdfsdfsd:String = "werwe"
//    implicit val sdfsdfs:String = "wangwu"
    implicit val sssss:Int = 88
    def ooxx(age:Int)(implicit name:String ): Unit ={
      println(name+" "+age)
    }

//    ooxx("zhangsan")
//    ooxx(66)("jkljkl")
//    ooxx(66)

    println("========隐式转换参数01========")
    implicit val powq:String = "wangwu"
    def sdfsf(implicit name:String): Unit = {
      println(name)
    }
    // 调用上述方法，因为参数有隐式转换，不需要写参数和括号
    sdfsf

    println("========隐式转换参数02========")
    // 这种情况必须两个参数都传，缺一不可
    def sdfsf1(implicit name:String="dengxiaoyu", age:Int): Unit = {
      println(name)
    }

    sdfsf1("zhangsan",2)

    println("柯里化解决上述问题")
    // 隐式转换的参数必须写到后面
    def sdfsf12(age:Int)(implicit name:String ): Unit ={
      println(name+" "+age)
    }

    sdfsf12(9)
  }
}

class XXX[T](list:util.Iterator[T]){

  def foreach( f:(T)=>Unit): Unit ={

    while(list.hasNext) f(list.next())
  }

}

//class XXX[T](list:util.LinkedList[T]){
//
//  def foreach( f:(T)=>Unit): Unit ={
//    val iter: util.Iterator[T] = list.iterator()
//    while(iter.hasNext) f(iter.next())
//  }
// 
//}

