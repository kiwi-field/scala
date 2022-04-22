# 模式匹配
## java中的switch如果想要匹配参数类型，只能用instanceof来判断，
## 如果我switch中既想判断参数类型，又想根据参数的值来判断怎么弄呢，可以使用模式匹配，代码如下

```scala
object Lesson06_match {

  def main(args: Array[String]): Unit = {
    val tup: (Double, Int, String, Boolean, Int) = (1.0,88,"abc",false,44)

    val iter: Iterator[Any] = tup.productIterator

    val res: Iterator[Unit] = iter.map(
      (x) => {
        x match {
          // scala中的switch和java不同的地方还有，case后面不需要加break,默认匹配到一个就不走了
          case 1 => println(s"$x...is 1")
          case 88 => println(s"$x ...is 88")
          case false => println(s"$x...is false")
          // 这里会将x的值传给w
          case w: Int if w > 50 => println(s"$w...is  > 50")
          // 其他都匹配不上的默认条件，相当于java中switch的default 
          case _ => println("wo ye bu zhi dao sha lei xing ")
        }
      }
    )
    while(res.hasNext)  println(res.next())

  }






}
```
