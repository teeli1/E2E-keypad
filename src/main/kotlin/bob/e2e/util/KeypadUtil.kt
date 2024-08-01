package bob.e2e.util

import java.security.MessageDigest
import java.util.*

object KeypadUtil {

    fun calculateHash(input: String): String {
        val bytes = input.toByteArray()
        val md = MessageDigest.getInstance("SHA-256")
        val digest = md.digest(bytes)
        return Base64.getEncoder().encodeToString(digest)
    }
}