# 偏函数应用
## 比如需要一个方法，接收一个任一类型的参数，固定返回string类型
## 偏函数写法
```scala
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

```
