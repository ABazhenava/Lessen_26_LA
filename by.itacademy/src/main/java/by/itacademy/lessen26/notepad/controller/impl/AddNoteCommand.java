package by.itacademy.lessen26.notepad.controller.impl;

import by.itacademy.lessen26.notepad.controller.Command;
import by.itacademy.lessen26.notepad.entity.Note;
import by.itacademy.lessen26.notepad.logic.LogicProvider;
import by.itacademy.lessen26.notepad.logic.NotebookLogic;

public class AddNoteCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final NotebookLogic logic = logicProvider.getNotebookLogic();

    @Override
    public String execute(String request) {
        String response = null;
        String[] params;
        Note newNote;

        params = request.split("\n");
        newNote = new Note();
        newNote.setTitle(params[1].split("=")[1]);
        newNote.setContent(params[2].split("=")[1]);

        try {
            logic.add(newNote);
            response = "Запись сохранена успешно.";
        } catch (Exception e) {
            return "Ошибка при добавлении записи: " + e.getMessage();
        }
//        } catch (LogicException e) {
//            throw new LogicException("Error adding note: " + e.getMessage(), e);
//        }

        return response;
    }
}
