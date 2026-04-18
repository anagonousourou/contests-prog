defmodule BirdCount do
  def today([]), do: nil
  def today([head | _tail]) do
    head
  end

  def increment_day_count([]), do: [1]
  def increment_day_count([head | tail]) do
    [head + 1 | tail]
  end

  def has_day_without_birds?([]), do: false
  def has_day_without_birds?([head | _tail]) when head == 0, do: true
  def has_day_without_birds?([head | tail]) when head != 0, do: has_day_without_birds?(tail)

  def total(list), do: total(list, 0)

  defp total([], result), do: result
  defp total([head | tail], result), do: total(tail, result + head)


  def busy_days(list), do: busy_days(list, 0)
  defp busy_days([], result), do: result
  defp busy_days([head | tail], result) do
    cond do
      head >= 5 -> busy_days(tail, result + 1)
      true -> busy_days(tail, result)
    end
  end
end
