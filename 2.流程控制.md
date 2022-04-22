# scala流程控制
## 流程控制(详细代码见lesson1类)
if条件判断
```scala
  // s"$变量名"用来取变量 
  def main(args: Array[String]): Unit = {
    var a=0
    if(a<=0) {
      println(s"$a<=0")
    } else {
      println(s"$a>0")
    }
  }
```

while循环(变量需要在外面定义)
```scala
  // 使用val也不行 b必须是变量
  var b = 0
  while(b<10) {
    println(b)
    // scala中 b++不可用  可以用 b=b+1 b+=1
    b+=1
  }
```

for循环
```scala
  // for scala只支持 增强for循环
  // 起始为1 步长为2  终值为10  to包含10  util不包含10
   val seq: Range.Inclusive = 1 to (10,2)
  println(seq)

   val a: Range = 1 until(10,1)
    for (i <- a if(i%2 == 0)){
      println(i)
    }
```

双重for循环 打印99乘法表
```scala
 for (i <- 1 to 9) {
   for (j <- 1 to 9) {
     if (j <= i) print(s"$i * $j = ${i*j} \t")
     if (j == i) println()
   }
 }
```

简化版双重for循环 打印99乘法表
```scala
  var num = 0
  // 双重for循环，并且j<=i的时候才会进for循环  比如当i=1时  j=1才能进来，其他情况j不会进来
  for (i <- 1 to 9;j <- 1 to 9 if j <= i) {
    num += 1
      if (j <= i) print(s"$i * $j = ${i*j} \t")
      if (j == i) println()
  }
  println(num)
```

yield关键字
```scala
println("==============yeild 收集for循环的值并做函数式处理=================")
  private val yeild: immutable.IndexedSeq[Int] = for (i <- 1 to 10) yield {
    var x = 8
    i + x
  }
  println(yeild)

  for (i<-yeild) {
    println(i)
  }
  }
```
