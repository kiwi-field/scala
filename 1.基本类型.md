# scala语言快速入门（一）

## 1.语言分类

```
语言分类：编译型，解释型！

1.  编译型：c。。。
2.  解释型：python。。。
3.  java是啥？
   1.  需要编译   字节码
   2.  解释执行/直接执行 
C：可移植性  代码 对应不同平台，各自编译
JAVA: 可移动性：一次编译，到处运行。。。JVM才是核心！

编译器！：编译型，解释型根本区别在哪？
   是否是强类型，什么是类型：宽度
   
SCALA  on  JVM  一定有一个编译

JAVA  /   SCALA
编译器  / 编译器   =>思考一个问题：scala代码和java不一样（编译器做了很多事情）
   JVM


再聊语言：模型：

   1.  面向过程的   第一类值：基本类型    +指针
   2.  面向对象的   第一类值：基本类型   +  对象类型
   3.  函数式的    第一类值：基本类型 + 对象类型  + 函数

SCALA  面向对象的函数式编程语言
```

统一类型

## 2.统一类型

[![Scala Type Hierarchy](img.assets/unified-types-diagram.svg)](https://docs.scala-lang.org/resources/images/tour
/unified-types-diagram.svg)



[`Any`](https://www.scala-lang.org/api/2.12.1/scala/Any.html)是所有类型的超类型，也称为顶级类 型。它定义了一些通用的方法如`equals`、`hashCode`和`toString`。`Any`有两个直接子类：`AnyVal`和`AnyRef`。

`AnyVal`代表值类型。有9个预定义的非空的值类型分别是：`Double`、`Float`、`Long`、`Int`、`Short`、`Byte`、`Char`、`Unit`和`Boolean`。`Unit`是不带任何意义的值类型，它仅有一个实例可以像这样声明：`()`。所有的函数必须有返回，所以说有时候`Unit`也是有用的返回类型。

AnyRef`代表引用类型。所有非值类型都被定义为引用类型。在Scala中，每个用户自定义的类型都是`AnyRef`的子类型。如果Scala被应用在Java的运行环境中，`AnyRef`相当于`java.lang.Object

这里有一个例子，说明了字符串、整型、布尔值和函数都是对象，这一点和其他对象一样

```scala
val list: List[Any] = List(
  "a string",
  732,  // an integer
  'c',  // a character
  true, // a boolean value
  () => "an anonymous function returning a string"
)

list.foreach(element => println(element))
```

这里定义了一个类型`List`的变量`list`。这个列表里由多种类型进行初始化，但是它们都是`scala.Any`的实例，所以可以把它们加入到列表中。

下面是程序的输出：

```
a string
732
c
true
<function>
```

## 3.使用scala

```
1.  开发     jdk      sdk（编译器）
2.  运行     jdk jre

V： spark 2.3.x > scala 2.11  > jre/jdk 1.8.uxxx
   https://www.oracle.com/technetwork/java/javase/archive-139210.html

--------------coder-------------

主流：使用  集成工具  ：  IDE

   1.  IDEA  +plugin  +编译器   》创建scala项目了！
   2.  启动屏幕：configure-》；plugins  
   
____
#学习scala
https://docs.scala-lang.org/zh-cn/tour/tour-of-scala.html

1.  main,class,object
​```text
主方法只能写在 object定义的文件中
object和class啥区别：
回顾一个问题：java中有一个知识点 静态
分号可有可无
scala是包级别区分，类名可以和文件名不一致

​```

var是变量  val是常量，相当于java中的final

类里 裸露的代码是默认构造。有默认构造
个性化构造
类名构造器的参数就是类的成员属性，默认是val类型，且是private
只有在类名构造器中的参数可以设置成var，其他方法函数中的参数都是val,且不允许设置成var
 

_____
```

## 4.伴生对象

在scala中伴生类和伴生对象一般是同时存在的，特点：一个为class（伴生对象），一个为object（伴生类）, 其名称是相同的。 在伴生类使用静态方法，伴生对象中定义动态方法。

```scala
object TestScala {
  private val p = new TestScala("刘能")
  println("testScala up")
  private var name = "邓小宇"
  def main(args: Array[String]): Unit = {
    println("testScala")
    p.printMsg()
  }
  println("testScala down")
}

/**
 * 类里 裸露的代码是默认构造。有默认构造
 * 个性化构造
 * 类名构造器的参数就是类的成员属性，默认是val类型，且是private
 * 只有在类名构造器中的参数可以设置成var，其他方法函数中的参数都是val,且不允许设置成var
 */
class TestScala(var sex:String){
  var a:Int = 3
//  var name = "zhangsan"
  def this(xname:Int) {
    this("abc")
  }
  println(s"person===$a")
  def printMsg():Unit={
    println(s"print msg${TestScala.name}")
  }
  println(s"person======${a+3}")
}
```

