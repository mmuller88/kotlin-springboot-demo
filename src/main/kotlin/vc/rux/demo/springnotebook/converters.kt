package vc.rux.demo.springnotebook

fun NoteDto.toModel() = Note(
    text = this.text
)