package com.lerkin.notepad;

import java.util.Date;
import java.util.Objects;

public class Note {
    private String title;
    private String description;
    private Date creationDate;

    public Note(String title, String description) {
        this.title = title;
        this.description = description;
        this.creationDate = new Date();
    }

    public Note() {
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Note note = (Note) o;
        return note.creationDate.equals(this.creationDate)
                && note.description.equals(this.description)
                && note.title.equals(this.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, creationDate);
    }

    @Override
    public String toString() {
        return title + "\n" + description + "\nCreation date: " + creationDate;
    }
}
