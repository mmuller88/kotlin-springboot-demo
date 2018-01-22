package vc.rux.demo.springnotebook

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import java.util.*

@Document
data class Note (
    @Id
    val id: String? = null,

    val text: String,
    val createdAt: Date = Date()
)

interface NoteRepository: MongoRepository<Note, String>, NoteRepositoryExtended {
}

interface NoteRepositoryExtended {
    fun updateText(id: String, text: String)

}

class NoteRepositoryImpl(val mongo: MongoTemplate): NoteRepositoryExtended {
    override fun updateText(id: String, text: String) {
        val update = Update().set("text", text)
        val query = Query(Criteria.where("id").`is`(id))
        mongo.updateFirst(query, update, Note::class.java)
    }

}