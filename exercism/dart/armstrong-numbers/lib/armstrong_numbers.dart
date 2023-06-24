
class ArmstrongNumbers {
  bool isArmstrongNumber(String number) {
    return number
            .split('')
            .map((e) => BigInt.parse(e).pow(number.length))
            .reduce((value, element) => value + element)
            .toString() ==
        number;
  }
}
