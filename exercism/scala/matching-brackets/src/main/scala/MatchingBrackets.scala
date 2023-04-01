import scala.annotation.tailrec
import scala.collection.mutable
object MatchingBrackets {
  val openingBrackets: Set[String] = Set("(", "{", "[")
  val closingBrackets: Set[String] = Set(")", "}", "]")
  val matchingBrackets: Map[String, String] = Map("(" -> ")", "{"-> "}", "[" -> "]")
  def isPaired(brackets: String): Boolean = {
    val bracketsStacks = mutable.Stack[String]()
    isPairedRecursive(brackets, bracketsStacks)
  }

  @tailrec
  private def isPairedRecursive(brackets: String, bracketsStacks: mutable.Stack[String]): Boolean = {
    val first =  if (brackets.isEmpty) ""  else  brackets.substring(0,1);
    val rest = if (brackets.isEmpty) ""  else  brackets.substring(1);
    if(brackets.isEmpty){
      bracketsStacks.isEmpty;
    }
    else if(openingBrackets.contains(first)){
      bracketsStacks.push(matchingBrackets(first))
      isPairedRecursive(rest, bracketsStacks)
    }
    else if(closingBrackets.contains(first) && bracketsStacks.nonEmpty && first.equals(bracketsStacks.top)){
      bracketsStacks.pop()
      isPairedRecursive(rest, bracketsStacks)
    }
    else if(closingBrackets.contains(first) && (bracketsStacks.isEmpty || !first.equals(bracketsStacks.top))){
      false
    }else{
      isPairedRecursive(rest, bracketsStacks)
    }
  }
}
