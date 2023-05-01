import java.io.DataOutputStream
import java.net.Socket

class MetricSender(
    private val serverAddress: String,
    private val serverPort: Int = 8080
) {

    fun sendSuccess() {
        val msg = "dv.success 1 " + System.currentTimeMillis()
        println(msg)
        Socket(serverAddress, serverPort).use {
            val dos = DataOutputStream(it.getOutputStream())
            dos.writeBytes(msg)
        }
    }

    fun sendDeath(caclCount: Long) {
        val msg = "dv.fail ${caclCount} " + System.currentTimeMillis()
        println(msg)
        Socket(serverAddress, serverPort).use {
            val dos = DataOutputStream(it.getOutputStream())
            dos.writeBytes(msg)
        }
    }
}
