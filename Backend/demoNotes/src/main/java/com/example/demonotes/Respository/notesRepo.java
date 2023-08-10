package com.example.demonotes.Respository;

import com.example.demonotes.dao.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface notesRepo extends JpaRepository<Notes, Integer> {
}
