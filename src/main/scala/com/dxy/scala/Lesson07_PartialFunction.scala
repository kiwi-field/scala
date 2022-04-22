package com.dxy.scala

/** @Author kiwi
 * @Date 2022/4/22 15:34
 * @Description 偏应用函数
 */
object Lesson07_PartialFunction {


  def main(args: Array[String]): Unit = {

    def xxx:PartialFunction[  Any,String] ={
      case "hello"  => "val is hello"
      case x:Int => s"$x...is int"
      case _ => "none"
    }

    println(xxx(44))
    println(xxx("hello"))
    println(xxx("hi"))





  }


}
