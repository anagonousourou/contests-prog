import java.math.BigInteger

object Board {

    fun getGrainCountForSquare(number: Int): BigInteger {
        if(number < 1 || number > 64){
            throw IllegalArgumentException("square must be between 1 and 64");
        }
        return BigInteger.TWO.pow(number -1);
    }

    fun getTotalGrainCount(): BigInteger {
        return BigInteger.TWO.pow(64).subtract(BigInteger.ONE);
    }
}
