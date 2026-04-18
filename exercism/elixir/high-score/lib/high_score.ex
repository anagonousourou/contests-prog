defmodule HighScore do

  @initial_score 0
  def new() do
    %{}
  end

  def add_player(scores, name, score \\ @initial_score)
  def add_player(scores, name, score) do
      Map.update(scores, name, score, fn _x -> score end)
  end

  def remove_player(scores, name) do
    Map.drop(scores, [name])
  end

  def reset_score(scores, name) do
    Map.update(scores, name, @initial_score, fn _x -> @initial_score end)
  end

  def update_score(scores, name, score) do
    Map.update(scores, name, score,  fn _x -> scores[name] + score end)
  end

  def get_players(scores) do
    Map.keys(scores)
  end
end
