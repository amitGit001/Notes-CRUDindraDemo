package com.example.demonotes;

import com.example.demonotes.Respository.notesRepo;
import com.example.demonotes.dao.Notes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoNotesApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DemoNotesApplication.class, args);

        notesRepo notesRepo = context.getBean(notesRepo.class);

        Notes notes = new Notes();
        notes.setNotesId(1);
        notes.setTitle("Hello world!");
        notes.setDescription("You should fear me because i am the alien you have been looking for without knowing it.");

        notesRepo.save(notes);
    }

}
