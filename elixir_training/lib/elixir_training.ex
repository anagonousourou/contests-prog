defmodule ElixirTraining do
  require Integer
  @moduledoc """
  Documentation for `ElixirTraining`.
  """

  @doc """
  Hello world.

  ## Examples

      iex> ElixirTraining.hello()
      :world

  """
  def hello do
    :world
  end

  def upper_case?(str) do
    String.upcase(str) === str
  end

  def square?(n) when n < 0, do: false

  def square?(n) do
    m = :math.sqrt(n) |> trunc
    m * m === n
  end

  def generate_rotations(input, result \\ [])
  def generate_rotations(input, _) when input === "", do: []
  def generate_rotations(input, result) when result === [], do: generate_rotations(input, [input])

  def generate_rotations(input, result) do
    latest_rotation = Enum.at(result, 0)

    new_rotation =
      String.slice(latest_rotation, 1..String.length(input)) <> String.first(latest_rotation)

    if new_rotation === input do
      result
    else
      generate_rotations(input, [new_rotation | result])
    end
  end

  def contain_all_rots(input, possibilities) do
    MapSet.subset?(MapSet.new(generate_rotations(input)), MapSet.new(possibilities))
  end

  def alternating_case(input) do
    input |> String.graphemes |> Enum.map(fn x ->
      cond do
        upper_case?(x) -> String.downcase(x)
        true ->  String.upcase(x)
      end
    end) |> Enum.join
  end

  def greet(name) do
    "Hello, #{name} how are you doing today?"
  end

  #https://www.codewars.com/kata/59ca8246d751df55cc00014c/train/elixir
  def survive(bullets, dragons) do
    dragons * 2 <= bullets
  end

  # https://www.codewars.com/kata/57eae65a4321032ce000002d/train/elixir
  def generate(str) do
    str |> String.graphemes |> Enum.map(fn x ->
      {d, _} = Integer.parse(x)
      cond do
        d < 5 -> "0"
        d >= 5  ->  "1"
      end
    end) |> Enum.join
  end

  def square_sum(nums) do
    nums |> Enum.map(fn x -> x * x end) |> Enum.sum
  end

  #https://www.codewars.com/kata/5ba38ba180824a86850000f7/train/elixir
  def remove_duplicates(list) do
    occurrences = Enum.frequencies(list)
    remove_duplicates(list, occurrences, [])
  end

  def remove_duplicates([], _, result), do: result
  def remove_duplicates([elt | rest], occurences, result) do
    cond do
      occurences[elt] > 1 -> remove_duplicates(rest, Map.update(occurences, elt, 0, fn x -> x - 1 end),  result)
      occurences[elt] == 1 -> remove_duplicates(rest, occurences, result ++ [elt])
    end
  end

  # https://www.codewars.com/kata/5d376cdc9bcee7001fcb84c0/train/elixir
  def odd_ones_out(nums) do
    occurrences = Enum.frequencies(nums)
    Enum.filter(nums, fn x -> Integer.is_even(occurrences[x]) end)
  end

  # https://www.codewars.com/kata/5e96332d18ac870032eb735f/train/elixir
  def womens_age(n) do
    if Integer.is_even(n) do
      "#{n}? That's just 20, in base #{div(n, 2)}!"
    else
      "#{n}? That's just 21, in base #{div(n - 1, 2)}!"
    end
  end

  # https://www.codewars.com/kata/550498447451fbbd7600041c/train/elixir
  def are_they_the_same(a, b) do
    (a |> Enum.sort |> Enum.map(fn x -> x * x end)) === Enum.sort(b)
  end

  # https://www.codewars.com/kata/55bf01e5a717a0d57e0000ec/train/elixir
  def persistence(n, result \\ 0)
  def persistence(n, result) do
    if n < 10 do
      result
    else
      persistence(n |> Integer.digits |> Enum.product, result + 1)
    end
  end

  # https://www.codewars.com/kata/530e15517bc88ac656000716/train/elixir

  @alphabet "abcdefghijklmnopqrstuvwxyz"
  @rotateda "nopqrstuvwxyzabcdefghijklm"

  def zipmap(list1,list2, result \\ %{})
  def zipmap([], [], result), do: result
  def zipmap([head1 | tail1], [head2 | tail2], result) do
    zipmap(tail1, tail2, Map.update(result, head1, head2, fn x -> x end))
  end
  def rot13(input) do
    mapping = zipmap(String.graphemes(@alphabet), String.graphemes(@rotateda))
    mapping = zipmap(@alphabet |> String.upcase |> String.graphemes, @rotateda |> String.upcase |> String.graphemes, mapping)
    String.graphemes(input) |> Enum.map(fn x -> Map.get(mapping, x, x) end) |> to_string
  end


  @opposites_directions [["NORTH","SOUTH"], ["SOUTH","NORTH"], ["EAST", "WEST"],["WEST", "EAST"]]

  def reducable?(directions) do
    Enum.chunk_every(directions, 2, 1) |> Enum.any?(fn x -> x in @opposites_directions end)
  end

  def directions_reduction([]),  do: []
  def directions_reduction([a]),  do: [a]
  def directions_reduction(["NORTH", "SOUTH" | other_directions]), do: directions_reduction(other_directions)
  def directions_reduction(["SOUTH", "NORTH" | other_directions]), do: directions_reduction(other_directions)
  def directions_reduction(["EAST", "WEST"   | other_directions]), do: directions_reduction(other_directions)
  def directions_reduction(["WEST", "EAST"   | other_directions]),  do: directions_reduction(other_directions)
  def directions_reduction([a, b | other_directions])  do
    reduced = [ a | directions_reduction([b | other_directions])]
    if reducable?(reduced) do
      directions_reduction(reduced)
    else
      reduced
    end
  end


end
