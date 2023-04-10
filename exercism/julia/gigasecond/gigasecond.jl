using Dates

function add_gigasecond(date::DateTime)
    date + Dates.Second(1_000_000_000)
end
