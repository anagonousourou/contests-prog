import java.util.stream.IntStream

object Hamming {

    fun compute(leftStrand: String, rightStrand: String): Int {
        if(leftStrand.length != rightStrand.length){
            throw IllegalArgumentException("left and right strands must be of equal length")
        }
        return IntStream.range(0, leftStrand.length)
            .filter({i -> !leftStrand.substring(i, i+1).equals(rightStrand.substring(i, i+1))})
            .count().toInt()
    }
}
