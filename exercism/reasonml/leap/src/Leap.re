let isLeapYear: int => bool =
  year =>
    if (year mod 400 == 0) {
      true;
    } else if (year mod 100 == 0) {
      false;
    } else {
      year mod 4 == 0;
    };
