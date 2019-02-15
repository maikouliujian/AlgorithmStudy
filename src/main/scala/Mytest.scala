object Mytest {

  def main(args: Array[String]): Unit = {
    println("aaaaaaaaaa")
    aaa("a","b","vc","d","l")
  }


  def aaa(haha: String*): Unit ={
    haha.foreach(a=>println(a))
  }


}
