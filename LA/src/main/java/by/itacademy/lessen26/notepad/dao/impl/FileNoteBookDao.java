package by.itacademy.lessen26.notepad.dao.impl;

import by.itacademy.lessen26.notepad.dao.NoteBookDao;
import by.itacademy.lessen26.notepad.entity.Note;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class FileNoteBookDao implements NoteBookDao {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public List<Note> save(Note n) {
        FileWriter writer = null;
        try {
            writer = new FileWriter("notes.txt", true);

            writer.write("Title: " + n.getTitle() + "\n");
            writer.write("Content: " + n.getContent() + "\n");
            writer.write("Date: " + n.getD() + "\n");
            writer.write("-----\n");
            System.out.println("Запись сохранена.");

        } catch (IOException e) {
            e.printStackTrace(); //?можно ли так
            System.err.println("Ошибка при сохранении записи: " + e.getMessage()); //? нужно ли
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.err.println("Ошибка при закрытии файла: " + e.getMessage());
                }
            }
        }
        return null; //? надо ли
    }

    @Override
    public List<Note> allNotes() {
        List<Note> notes = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("notes.txt"));
            String line;
            Note note = null;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Title: ")) {
                    note = new Note();
                    note.setTitle(line.substring(7));
                } else if (line.startsWith("Content: ")) {
                    note.setContent(line.substring(9));
                } else if (line.startsWith("Date: ")) {
                    try {
                        note.setD(DATE_FORMAT.parse(line.substring(6)));
                    } catch (ParseException e) {
                        System.err.println("Ошибка при чтении даты: " + e.getMessage());
                    }
                } else if (line.equals("-----")) {
                    notes.add(note);
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении записей: " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println("Ошибка при закрытии файла: " + e.getMessage());
                }
            }
        }
        return notes;
    }
}


