.number | if (. % 105) == 0  then "PlingPlangPlong" 
          elif (. % 15) == 0  then "PlingPlang" 
          elif (. % 21) == 0  then "PlingPlong"
          elif (. % 35) == 0  then "PlangPlong"
          elif (. % 3) == 0  then "Pling"
          elif (. % 5) == 0  then "Plang"
          elif (. % 7) == 0  then "Plong"
          else . end
#