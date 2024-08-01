package bob.e2e.repository

import bob.e2e.model.KeypadInput
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface KeypadInputRepository : MongoRepository<KeypadInput, String>