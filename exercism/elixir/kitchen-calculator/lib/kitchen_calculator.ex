defmodule KitchenCalculator do
  def get_volume(volume_pair) do
    elem(volume_pair, 1)
  end

  defp conversion_table(unit) do
    case unit do 
      :cup -> 240
      :fluid_ounce -> 30
      :teaspoon -> 5
      :tablespoon -> 15 
      :milliliter -> 1
    end
  end

  def to_milliliter(volume_pair) do
    {:milliliter, conversion_table(elem(volume_pair, 0)) * elem(volume_pair, 1)}
  end

  def from_milliliter(volume_pair, unit) do
    {unit, elem(volume_pair, 1) / conversion_table(unit)}
  end

  def convert(volume_pair, unit) do
    to_milliliter(volume_pair) |> from_milliliter(unit)
  end
end
