package com.example.demonotes.Service.impl;

import com.example.demonotes.Respository.notesRepo;
import com.example.demonotes.Service.notesService;
import com.example.demonotes.entity.Notes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class notesServImpl implements notesService {

    @Autowired
    private notesRepo notesRepo;

    @Override
    public Notes createNotes(Notes notes)
    {
        Notes notes1 = new Notes();

        notes1.setNotesId(notes.getNotesId());
        notes1.setTitle(notes.getTitle());
        notes1.setDescription(notes.getDescription());

        return notesRepo.save(notes1);
    }

    @Override
    public Notes getNoteById(Integer notesId)
    {
        Optional<Notes> notes = notesRepo.findById(notesId);
        return notes.orElse(null);
    }
    @Override
    public List<Notes> fetchAllNotes()
    {
        return notesRepo.findAll();
    }

    @Override
    public Notes updateNoteById(Integer notesId, Notes notes)
    {
        Notes notes1 = notesRepo.findById(notesId).get();

        notes1.setTitle(notes.getTitle());
        notes1.setDescription(notes.getDescription());

//        if(Objects.nonNull(notes.getTitle()) && !"".equalsIgnoreCase(notes.getTitle())){
//            notes1.setTitle(notes.getTitle());
//        }
//        if (Objects.nonNull(notes.getDescription()) && !"".equalsIgnoreCase(notes.getDescription())){
//            notes1.setDescription(notes.getDescription());
//        }

        notesRepo.save(notes1);

        return notes1;
    }

    @Override
    public Notes updateNote(Notes notes)
    {
        Notes notes1 = new Notes();

        notes1.setNotesId(notes.getNotesId());
        notes1.setTitle(notes.getTitle());
        notes1.setDescription(notes.getDescription());

        notesRepo.save(notes1);

        return notes1;
    }

    @Override
    public void deleteNotes(int notesId)
    {
        Notes notes1 = notesRepo.findById(notesId).get();
        notesRepo.delete(notes1);
    }
}
