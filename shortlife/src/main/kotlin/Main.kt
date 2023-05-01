
fun main(args: Array<String>) {

    // fib number
    val n = args.find { it.contains("--n") }
        ?.substringAfter("=")
        ?.toInt()
        ?: 30

    // death probability
    val dp = args.find { it.contains("--dp") }
        ?.substringAfter("=")
        ?.toDouble()
        ?: 0.000000001

    // Receiver Address
    val receiverAddress = args.find { it.contains("--ra") }
        ?.substringAfter("=")
        ?: "localhost"

    println("Fib number: $n")
    println("Death probability: $dp")
    println("ReceiverAddress: $receiverAddress")

    val metricSender = MetricSender(receiverAddress, 8080)
    ShortLife(dp, metricSender).start(n)
}