
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

    // Receiver address
    val receiverAddress = args.find { it.contains("--ra") }
        ?.substringAfter("=")
        ?: "localhost"

    // Receiver port
    val receiverPort = args.find { it.contains("--rp") }
        ?.substringAfter("=")
        ?.toInt()
        ?: 8080

    println("Fib number: $n")
    println("Death probability: $dp")
    println("Receiver address: $receiverAddress")
    println("Receiver port: $receiverPort")

    val metricSender = MetricSender(receiverAddress, receiverPort)
    ShortLife(dp, metricSender).start(n)
}