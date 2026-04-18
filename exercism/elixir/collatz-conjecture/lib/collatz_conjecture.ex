defmodule CollatzConjecture do

    @doc """
  calc/1 takes an integer and returns the number of steps required to get the
  number to 1 when following the rules:
    - if number is odd, multiply with 3 and add 1
    - if number is even, divide by 2
  """
  @spec calc(input :: pos_integer()) :: non_neg_integer()
  def calc(input), do: calc(input, 0)

  defp calc(input, result) when is_integer(input) and (input > 0) do
    cond do
      input == 1 -> result
      rem(input, 2)  == 0 -> calc(div(input, 2), result + 1)
      true -> calc(3 * input + 1, result + 1)
    end
  end
end
