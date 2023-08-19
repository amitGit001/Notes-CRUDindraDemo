package com.example.demonotes.entity;

import jakarta.persistence.*;

@Entity

public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int notesId;

    @Column(name = "Title", nullable = false)
    public String title;

    @Column(name = "Description", nullable = false)
    public String description;

    public int getNotesId() {
        return notesId;
    }

    public void setNotesId(int notesId) {
        this.notesId = notesId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Notes{" +
                "notesId=" + notesId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @ManyToOne
    @JoinColumn(name = "userId")
    User user;
}
