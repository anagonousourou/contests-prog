const allergens_score = Dict("eggs" => 1, "peanuts" => 2, "shellfish" => 4, "strawberries" => 8, "tomatoes" => 16,
                                "chocolate" => 32, "pollen" => 64, "cats" => 128)
function allergic_to(score, allergen)
    allergens_score[allergen] & score == allergens_score[allergen]
end

function allergy_list(score)
    filter(allergen_score_pair ->  allergic_to(score, allergen_score_pair.first), allergens_score) |> keys
end