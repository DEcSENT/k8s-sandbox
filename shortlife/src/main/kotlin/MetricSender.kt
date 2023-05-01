import java.io.DataOutputStream
import java.net.Socket

class MetricSender(
    private val serverAddress: String,
    private val serverPort: Int = 8080
) {

    fun sendSuccess() {
        val msg = getGraphiteMsg("dv.success 1")
        println(msg)
        Socket(serverAddress, serverPort).use {
            val dos = DataOutputStream(it.getOutputStream())
            dos.writeBytes(msg)
        }
    }

    fun sendDeath(caclCount: Long) {
        val msg = getGraphiteMsg("dv.fail ${caclCount}")
        println(msg)
        Socket(serverAddress, serverPort).use {
            val dos = DataOutputStream(it.getOutputStream())
            dos.writeBytes(msg)
        }
    }

    /**
     * Creates message in Graphite format: metric_path value timestamp\n
     */
    private fun getGraphiteMsg(msg: String): String {
        return msg + " " + getCurrentTimeInSeconds() + "\n"
    }

    private fun getCurrentTimeInSeconds(): Long {
        return System.currentTimeMillis() / 1000
    }
}
