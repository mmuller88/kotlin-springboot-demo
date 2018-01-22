package vc.rux.demo.springnotebook

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/")
class NotebookAPI(val noteRepo: NoteRepository) {
    @GetMapping("/")
    fun list(): MutableList<Note> {
        return noteRepo.findAll()
    }

    @PostMapping("/")
    fun create(@RequestBody noteDto: NoteDto) {
        println("Got note to be created: $noteDto")
        val note = Note(text = noteDto.text)
        noteRepo.insert(note)
    }

    @DeleteMapping("/{noteId}")
    fun delete(@PathVariable("noteId") noteId: String) {
        noteRepo.deleteById(noteId)
    }

    @PutMapping("/{noteId}")
    fun update(
        @PathVariable("noteId") noteId: String,
        @RequestBody note: NoteDto
    ) {
        print("update note#$noteId text to '${note.text}'")
        noteRepo.updateText(noteId, note.text)
    }
}


