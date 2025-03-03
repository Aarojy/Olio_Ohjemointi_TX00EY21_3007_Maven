package Task6_4.model;

import java.util.ArrayList;

public class Notebook {
    private ArrayList<Note> notes;

    public Notebook() {
        notes = new ArrayList<>();
    }

    public void addNote(String title, String text) {
        notes.add(new Note(title, text));
    }

    public void removeNoteByTitle(String title) throws Exception {
        for (Note note : notes) {
            if (note.getTitle().equals(title)) {
                notes.remove(note);
                return;
            }
        }
        throw new Exception("Note not found");
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public Note getNoteByTitle(String title) throws Exception {
        for (Note note : notes) {
            if (note.getTitle().equals(title)) {
                return note;
            }
        }
        throw new Exception("Note not found");
    }

    public boolean titleInUse(String title) {
        for (Note note : notes) {
            if (note.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }
}
