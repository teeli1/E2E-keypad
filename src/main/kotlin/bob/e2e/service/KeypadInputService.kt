package bob.e2e.service

import bob.e2e.model.KeypadInput
import bob.e2e.repository.KeypadInputRepository
import bob.e2e.util.KeypadUtil
import org.springframework.stereotype.Service

@Service
class KeypadInputService(private val repository: KeypadInputRepository) {

    fun saveInput(input: KeypadInput): KeypadInput {
        return repository.save(input)
    }

    fun getAllInputs(): List<KeypadInput> {
        return repository.findAll()
    }

    fun generateKeypadResponse(input: String): Map<String, Any> {
        val keypad = (1..9).map { it.toString() } + listOf("*", "0", "#")
        val keypadWithHashes = keypad.associateWith { KeypadUtil.calculateHash(it) }
        return mapOf(
            "input" to input,
            "keypad" to keypadWithHashes
        )
    }
}