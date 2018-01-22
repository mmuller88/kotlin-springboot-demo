package vc.rux.demo.springnotebook

import com.fasterxml.jackson.annotation.JsonInclude


@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class NoteDto(
    val id: String? = null,
    val text: String
)