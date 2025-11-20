package fr.anagonou


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@main
def main(): Unit = {


  //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
  // to see how IntelliJ IDEA suggests fixing it.
  (1 to 5).foreach(println)

  for (i <- 1 to 5) {
    //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
    // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
    println(s"i = $i")
  }
}


object Order {

  def descendingOrder(num: Int): Int = {
    num.toString.map(_.asDigit).sorted.mkString.toInt
  }


}

def plural(n: Int): Boolean = n != 1


val geese = Array("African", "Roman Tufted", "Toulouse", "Pilgrim", "Steinbacher")

def gooseFilter(birds: List[String]): List[String] = {
  birds.filter(p => !geese.contains(p))
}


def makeUpperCase(s: String): String = s.toUpperCase


def multiTable(n: Int): String =
  (1 to 10).map(i => s"$i * $n = ${i * n}").mkString("\n")



def quarterOf(month: Int): Int = {
  if( (1 to 3).contains(month)){
    1;
  }
  else if((4 to 6).contains(month)){
    2;
  }
  else if ((6 to 9).contains(month)) {
    3;
  }
  else{
    4;
  }
}

