function bmi(weight, height)
    bmiVal = weight / (height ^ 2)
    if bmiVal ≤ 18.5
        "Underweight"
    elseif bmiVal ≤ 25.0
        "Normal"
    elseif bmiVal ≤ 30.0
        "Overweight"
    else
        "Obese"
    end
  end