#https://www.codewars.com/kata/5a6663e9fd56cb5ab800008b/train/julia

function human_years_cat_years_dog_years(human_years) 
    [human_years, 15 + 9 * (human_years > 1 ? 1 : 0) + max(human_years -2 , 0) * 4, 15 + 9 * (human_years > 1 ? 1 : 0) + max(human_years - 2 , 0) * 5]
end


using FactCheck

facts("Basic tests") do
  context("Should pass fixed tests") do
    @fact human_years_cat_years_dog_years(1) --> [1,15,15]
    @fact human_years_cat_years_dog_years(2) --> [2,24,24]
    @fact human_years_cat_years_dog_years(10) --> [10,56,64]
  end
end