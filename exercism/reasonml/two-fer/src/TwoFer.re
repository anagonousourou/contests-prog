let twoFer: option(string) => string =
  nameOpt => {
    let name =
      switch (nameOpt) {
      | Some(x) => x
      | None => "you"
      };
    "One for " ++ name ++", one for me.";
  };
