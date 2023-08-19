package com.example.demonotes.Service;

import com.example.demonotes.entity.Notes;

import java.util.List;

public interface notesService {

    public Notes createNotes(Notes note);

    public Notes getNoteById(Integer notesId);

    public List<Notes> fetchAllNotes();

    public Notes updateNoteById(Integer notesId, Notes note);

    public Notes updateNote(Notes notes);

    public void deleteNotes(int notesId);
}
