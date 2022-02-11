package com.lerkin.notepad;

public class Notepad {
    private Note[] notes;
    private int lastInsert = -1;

    public Notepad(int maxNotesCount) {
        notes = new Note[maxNotesCount];
    }

    public void addNote(Note note) {
        notes[++lastInsert] = note;
    }

    public void removeNote(int index) {
        notes[index] = null;
        for (int i = index; i < lastInsert; i++) {
            Note temp = notes[i];
            notes[i] = notes[i + 1];
            notes[i + 1] = temp;
        }
        lastInsert--;
    }

    public boolean isFull() {
        return lastInsert >= notes.length - 1;
    }

    public boolean isEmpty() {
        return lastInsert < 0;
    }

    public int getLastInsertIndex() {
        return lastInsert;
    }

    @Override
    public String toString() {
        String message = "";
        for (int i = 0; i < notes.length; i++) {
            if (notes[i] != null) {
                message = message + (i + 1) + ". " + notes[i] + "\n\n ";
            } else {
                break;
            }
        }
        return message;
    }
}
