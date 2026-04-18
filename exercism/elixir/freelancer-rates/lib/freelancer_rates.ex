defmodule FreelancerRates do
  def daily_rate(hourly_rate) do
    8.0 * hourly_rate
  end

  def apply_discount(before_discount, discount) do
    (before_discount - (before_discount * (discount / 100.0)))
  end

  def monthly_rate(hourly_rate, discount) do
    (daily_rate(hourly_rate) * 22) |> apply_discount(discount) |> Float.ceil |> trunc
  end

  def days_in_budget(budget, hourly_rate, discount) do
    ((budget / monthly_rate(hourly_rate, discount)) * 22) |> Float.floor(1)
  end
end
