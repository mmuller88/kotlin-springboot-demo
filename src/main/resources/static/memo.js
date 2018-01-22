

function updateNotes() {
    $.get("/api/", function (list) {
        var htmlString = "<div class='list-group'>"

        for(var row of list) {
            const date = `<span class="text-muted"><i>${row.createdAt}</i></span>`
            const removeBtn = `<button type="button" class="btn btn-default btn-xs" onclick="removeNote('${row.id}')"> <span class="glyphicon glyphicon glyphicon-remove" aria-hidden="true"></span></button>`
            const noteContent = `<div style="margin-bottom: 0; font-family: monospace; white-space: pre" >${row.text} </div>`
            const badge = `    <span class="badge" style="background: transparent">${removeBtn}</span>`
            htmlString += `<a href="#" onclick="editNote('${row.id}', '${escape(row.text)}')" class="list-group-item">${noteContent} ${date} ${badge}</a>`
        }
        htmlString += "</ul>"

        $("#notes").html(htmlString)
    });
}

function saveNote() {
    var str = $("#noteText").val().trim()
    console.log(`Note to be saved: ${str}`)
    if (str.length == 0) {
        alert("Please put your note text")
        return
    }

    // create new one
    if ($("#noteId").val().length == 0) {
        $.ajax({
            type: 'POST',
            url: '/api/',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify({text: str}),
            success: function() {
                location.reload();
                alert("Your note has been saved")
            }
        })
    } else {
        $.ajax({
            type: 'PUT',
            url: `/api/${$("#noteId").val()}`,
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify({text: str}),
            success: function(a, b,c ) {
                location.reload();
                alert("Your note has been updated")
            }
        })
    }

}

function removeNote(noteId) {
    console.log("About to remove " + noteId)
    $.ajax({
        type: 'DELETE',
        url: `/api/${noteId}`,
        success: function() {
            location.reload();
        }
    })
}

function editNote(noteId, text) {
    $("#noteText").val(unescape(text))
    $("#noteId").val(noteId)

    $("#noteModal").modal()
}