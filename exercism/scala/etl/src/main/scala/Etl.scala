

object Etl {
  def transform(scoreMap: Map[Int, Seq[String]]): Map[String, Int] = {
    val reverseMap = for ((k,v) <- scoreMap) yield for (c <- v) yield (c.toLowerCase(), k)
    reverseMap.flatten.toMap
  }
}
