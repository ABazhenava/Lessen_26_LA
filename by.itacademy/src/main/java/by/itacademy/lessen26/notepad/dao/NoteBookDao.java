package by.itacademy.lessen26.notepad.dao;

import by.itacademy.lessen26.notepad.entity.Note;

import java.util.List;

public interface NoteBookDao {

    List<Note> save(Note n);

    List<Note> allNotes();



}
