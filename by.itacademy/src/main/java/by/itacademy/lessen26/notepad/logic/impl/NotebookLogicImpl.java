package by.itacademy.lessen26.notepad.logic.impl;

import by.itacademy.lessen26.notepad.dao.DaoProvider;
import by.itacademy.lessen26.notepad.dao.NoteBookDao;
import by.itacademy.lessen26.notepad.entity.Note;
import by.itacademy.lessen26.notepad.logic.NotebookLogic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NotebookLogicImpl implements NotebookLogic {
    private final DaoProvider provider = DaoProvider.getInstance();
    private final NoteBookDao dao = provider.getNoteBookDao();

    public void add(Note n) {
        dao.save(n);
    }

    public void add(String title, String content) {
        Note n = new Note(title, content);
        dao.save(n);
    }

    public List<Note> find(String text) {
        List<Note> result = new ArrayList<Note>();
        List<Note> myNotes = dao.allNotes();

        for (Note n : myNotes) {
            if (isTextInNote(n, text)) {
                result.add(n);
            }
        }
        return result;
    }

    private boolean isTextInNote(Note n, String text) {
        return n.getTitle().contains(text) || n.getContent().contains(text);
    }

    public List<Note> find(Date date) {
        List<Note> result = new ArrayList<Note>();
        List<Note> myNotes = dao.allNotes();

        for (Note n : myNotes) {
            if (n.getD().equals(date)) {
                result.add(n);
            }
            return result;
        }
        return result; //? надо
    }

    public List<Note> allNotes() {
        return dao.allNotes();
    }
}

