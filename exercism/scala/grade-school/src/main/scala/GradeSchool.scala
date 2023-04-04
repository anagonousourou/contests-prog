import scala.collection.immutable.SortedMap
import scala.collection.mutable

class School {
  type DB = Map[Int, Seq[String]]
  private val theDb = mutable.Map[Int, Seq[String]]()
  def add(name: String, g: Int): Unit = {
     theDb(g) = theDb.getOrElse(g, Seq.empty[String]) :+ name
  }

  def db (): DB = {
    theDb.to(DB)
  }

  def grade(g: Int): Seq[String] = theDb.getOrElse(g, Seq.empty[String])

  def sorted() : DB = {
    theDb.transform((key, value) => value.sorted).to(SortedMap)
  }
}

