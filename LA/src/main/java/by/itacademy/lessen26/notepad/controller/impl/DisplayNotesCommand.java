package by.itacademy.lessen26.notepad.controller.impl;

import by.itacademy.lessen26.notepad.controller.Command;
import by.itacademy.lessen26.notepad.entity.Note;
import by.itacademy.lessen26.notepad.logic.LogicProvider;
import by.itacademy.lessen26.notepad.logic.NotebookLogic;

import java.util.ArrayList;
import java.util.List;

public class DisplayNotesCommand implements Command {
    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final NotebookLogic logic = logicProvider.getNotebookLogic();

    @Override
    public String execute(String request) {
        List<Note> notes = new ArrayList<>();
        StringBuilder response = new StringBuilder();
        try {
            List<Note> n = logic.allNotes();
            for (Note note : n) {
                response.append(note.toString()).append("\n");
            }
        } catch (Exception e) {
            response.append("Возникла ошибка при получении записей: ").append(e.getMessage());
        }
        return response.toString();
    }
}
