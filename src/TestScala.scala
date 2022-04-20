/** @Author kiwi
 * @Date 2022/4/20 11:01
 * @Description TODO
 */
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
