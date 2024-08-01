package bob.e2e.model


import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "keypads")
data class KeypadInput(
    @Id val id: String? = null,
    val input: String
)