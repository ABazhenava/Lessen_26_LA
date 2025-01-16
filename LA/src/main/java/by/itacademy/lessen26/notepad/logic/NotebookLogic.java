package by.itacademy.lessen26.notepad.logic;

import java.util.Date;
import java.util.List;

import by.itacademy.lessen26.notepad.entity.Note;

public interface NotebookLogic {

	public void add(Note n);

	public void add(String title, String content);

	public List<Note> find(String text);

	public List<Note> find(Date date);

	public List<Note> allNotes();
}
