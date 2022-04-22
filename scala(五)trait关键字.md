# trait关键字
## 在java中只能单继承、多实现,满足不了多继承的情况，scala中trait关键字
## 就是用来解决这个问题的,想要被多继承的类必须用trait关键字修饰

### 使用方式
```scala
trait  God{
  def say(): Unit ={
    println("god...say")
  }
}

trait Mg{
  def ku(): Unit ={
    println("mg...say")
  }
  def haiRen():Unit
}

class Person(name:String)  extends   God with Mg{

  def hello(): Unit ={
    println(s"$name say hello")
  }

  override def haiRen(): Unit = {
    println("ziji shixian ....")
  }
}


object Lesson04_trait {

  def main(args: Array[String]): Unit = {

    val p = new Person("zhangsan")
    p.hello()
    p.say()
    p.ku()
    p.haiRen()

  }
}
```
