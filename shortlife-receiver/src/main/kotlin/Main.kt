import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.ServerSocket

fun main(args: Array<String>) {
    println("Start receiver")

    val serverSocket = ServerSocket(2003)
    println("Server started on port 8080")

    while (true) {
        val clientSocket = serverSocket.accept()
        println("Client connected: ${clientSocket.inetAddress.hostAddress}")

        val reader = BufferedReader(InputStreamReader(clientSocket.getInputStream()))
        var line: String? = reader.readLine()
        while (line != null) {
            println("Received message: $line")
            line = reader.readLine()
        }

        println("Client disconnected")
        clientSocket.close()
    }
}
