import java.lang.Exception
import java.math.BigInteger

class ShortLife(
    private val deathProbability: Double,
    private val sender: MetricSender
) {

    private var iterationCount: BigInteger = BigInteger.ZERO

    fun start(n: Int) {

        try {
            println("Success result: " + calcFibonacciRec(n))
            println("Iterations: $iterationCount")

            try {
                sender.sendSuccess()
            } catch (e: Exception) {
                println("Died after success")
                e.printStackTrace()
            }

        } catch (e: Exception) {
            println("Died after iterations: $iterationCount")

            try {
                sender.sendDeath(iterationCount.toLong())
            } catch (e: Exception) {
                println("Died after died")
                e.printStackTrace()
            }
        }
    }

    private fun calcFibonacci(n: Int): BigInteger {
        if (n == 0) return BigInteger.ZERO
        var n0 = BigInteger.ZERO
        var n1 = BigInteger.ONE

        for (x in 2..n) {
            val n2 = n0 + n1
            n0 = n1
            n1 = n2
        }
        return n1
    }

    private fun calcFibonacciRec(n: Int): BigInteger {
        iterationCount = iterationCount.inc()
        dieIfItYourTime()
        if (n == 0) return BigInteger.ZERO
        if (n == 1) return BigInteger.ONE
        return calcFibonacciRec(n - 1) + calcFibonacciRec(n - 2)
    }

    private fun dieIfItYourTime() {
        if (Math.random() < deathProbability) {
            throw IllegalStateException("It is your time...")
        }
    }
}
