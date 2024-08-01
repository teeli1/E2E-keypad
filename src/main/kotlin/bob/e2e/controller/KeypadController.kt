package bob.e2e.controller

import bob.e2e.model.KeypadInput
import bob.e2e.service.KeypadInputService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/keypad")
class KeypadInputController(private val service: KeypadInputService) {

    @PostMapping("/input")
    fun saveInput(@RequestBody input: KeypadInput): ResponseEntity<Map<String, Any>> {
        service.saveInput(input)
        val jsonResponse = service.generateKeypadResponse(input.input)
        return ResponseEntity.ok(jsonResponse)
    }

    @GetMapping("/inputs")
    fun getAllInputs(): ResponseEntity<List<KeypadInput>> {
        val inputs = service.getAllInputs()
        return ResponseEntity.ok(inputs)
    }
}