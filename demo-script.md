Live coding script
===============

### Basic app

* Hi from kotlin
* Type inference 
* var/val
* `SpringApplication.run`
* jackson kotlin binding

### REST controller

* Add rest controller
* it's possible to put more than 1 public class in 1 file
* Add data class `NoteDTO` (`id`, `text`)
* Showoff data class using println
* Return that note from handler
* Create note(make it fail)
* Add `@JsonInclude(JsonInclude.Include.NON_EMPTY)` on DTO

### Database layer


* Add model `Note` (`id`, `text`, `createdAt`)
* Add `NoteRepository` repository
* `NoteRepository` injection 
* Implement actual model creation and query
* Showoff creation and removal
* Records removal

### Update records

* PUT method on note
* Add extended repository interface
* Inject `mongo: MongoTemplate`
* Construct `Update` and `Query`(using `Criteria` builder) 

### Converters


