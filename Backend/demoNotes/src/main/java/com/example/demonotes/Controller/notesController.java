package com.example.demonotes.Controller;

import com.example.demonotes.Service.notesService;
import com.example.demonotes.dao.Notes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/")
public class notesController {

    @Autowired
    private notesService notesService;

    @PostMapping("/notes")
    public Notes createNotes(@RequestBody Notes notes) {
        return notesService.createNotes(notes);
    }

    @GetMapping("/notes/{notesId}")
    public Notes getNoteById(@PathVariable("notesId") Integer notesId)
    {
        return notesService.getNoteById(notesId);
    }

    @GetMapping("/notes")
    public List<Notes> fetchAllNotes() {
        return notesService.fetchAllNotes();
    }

    @PatchMapping("/notes/{notesId}")
    public Notes updateNoteById(@PathVariable("notesId") Integer notesId, @RequestBody Notes notes) {
        return notesService.updateNoteById(notesId, notes);
    }

    @PutMapping("/notes")
    public Notes updateNote(@RequestBody Notes notes) {
        return notesService.updateNote(notes);
    }

    @DeleteMapping("/notes/{notesId}")
    public void deleteNotes(@PathVariable("notesId") int notesId) {
        notesService.deleteNotes(notesId);
    }
}
