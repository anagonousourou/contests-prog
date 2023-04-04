object Bob {
  def response(statement: String): String = {
    if(statement.isBlank){
      "Fine. Be that way!"
    }
    else if(capital(statement) && statement.trim().endsWith("!")){
      "Whoa, chill out!"
    }else if(capital(statement) && statement.trim().endsWith("?")){
      "Calm down, I know what I'm doing!"
    }
    else if(capital(statement)){
      "Whoa, chill out!"
    }
    else if(statement.trim().endsWith("?")){
      "Sure."
    }else{
      "Whatever."
    }

  }

  def capital(statement: String): Boolean ={
    statement.filter(c => c.isLetter).forall(c => c.isUpper) && statement.exists(c => c.isLetter);
  }

}
