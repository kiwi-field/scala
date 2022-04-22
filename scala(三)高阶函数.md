# scala高阶函数

## 无返回值函数
```scala
    def fun01() {
      println("hello world")
    }

    fun01()
    var x = 3
    var y = fun01()
    println(y)
```

## 有返回值函数
```scala
   //想有返回
    //    public void sdfsd(){}
    //    public String sdfsdf(){}
    //有return必须给出返回类型
    def fun02() = {

      new util.LinkedList[String]()
    }

    //参数：必须给出类型，是val
    //只有在类名构造器中的参数可以设置成var，其他方法函数中的参数都是val,且不允许设置成var
    def fun03(a: Int): Unit = {
      println(a)
    }

    fun03(33)
```

## 递归函数
```scala

    //递归先写触底！  触发什么报错呀
    def fun04(num: Int): Int = {
      if (num == 1) {
        num
      } else {
        num * fun04(num - 1)
      }
    }

    val i: Int = fun04(4)
    println(i)
```

## 默认值函数
```scala
    def fun05(a: Int = 8, b: String = "abc"): Unit = {
      println(s"$a\t$b")
    }

    //    fun05(9,"def")
    fun05(22)
    fun05(b = "ooxx")
```

## 匿名函数
```scala
    //函数是第一类值
    //函数：
    //1，签名 ：(Int,Int)=>Int ：  （参数类型列表）=> 返回值类型
    //2，匿名函数： (a:Int,b:Int) => { a+b }  ：（参数实现列表）=> 函数体
    var xx: Int = 3

    var yy: (Int, Int) => Int = (a: Int, b: Int) => {
      a + b
    }

    val w: Int = yy(3, 4)
    println(w)
```

## 嵌套函数
```scala
    def fun06(a: String): Unit = {

      def fun05(): Unit = {
        println(a)
      }

      fun05()
    }

    fun06("hello")
```
## 偏应用函数
```scala
    println("--------6.偏应用函数---------")

    def fun07(date: Date, tp: String, msg: String): Unit = {

      println(s"$date\t$tp\t$msg")
    }

    fun07(new Date(), "info", "ok")

    var info = fun07(_: Date, "info", _: String)
    var error = fun07(_: Date, "error", _: String)
    info(new Date, "ok")
    error(new Date, "error...")
```

## 可变参数
```scala
    println("--------7.可变参数---------")

    def fun08(a: Int*): Unit = {
      for (e <- a) {
        println(e)
      }
      //      def foreach[U](f: AA => U): Unit
      //      a.foreach(   (x:Int)=>{println(x)}   )
      // 如果匿名函数中的变量在方法体只用了一次，可以用下面这个写法
      //      a.foreach(   println(_)   )
      a.foreach(println)
    }

    fun08(2)
    fun08(1, 2, 3, 4, 5, 6)
```

## 高阶函数
```scala
    //函数作为参数，函数作为返回值
    //函数作为参数
    def computer(a: Int, b: Int, f: (Int, Int) => Int): Unit = {
      val res: Int = f(a, b)
      println(res)
    }
    computer(3, 8, (x: Int, y: Int) => {
      x + y
    })
    computer(3, 8, (x: Int, y: Int) => {
      x * y
    })
    // 当方法签名和方法体变量顺序一致的时候可以使用_代表第1个变量和第2个变量
    computer(3, 8, _ * _)
    //函数作为返回值：
    def factory(i: String): (Int, Int) => Int = {
      def plus(x: Int, y: Int): Int = {
        x + y
      }
      if (i.equals("+")) {
        plus
      } else {
        (x: Int, y: Int) => {
          x * y
        }
      }
    }


    computer(3, 8, factory("-"))
```
### 柯里化
```scala
    println("--------9.柯里化---------")

    def fun09(a: Int)(b: Int)(c: String): Unit = {
      println(s"$a\t$b\t$c")
    }

    fun09(3)(8)("sdfsdf")

    // def fun111(a:Any*)这种变量元素需要做类型转换 可以使用柯里化，不需要类型转换

    def fun10(a: Int*)(b: String*): Unit = {
      a.foreach(println)
      b.foreach(println)
    }

    fun10(1, 2, 3)("sdfs", "sss")
```
