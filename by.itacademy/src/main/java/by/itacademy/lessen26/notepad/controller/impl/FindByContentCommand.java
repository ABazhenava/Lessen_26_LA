package by.itacademy.lessen26.notepad.controller.impl;

import by.itacademy.lessen26.notepad.controller.Command;
import by.itacademy.lessen26.notepad.entity.Note;
import by.itacademy.lessen26.notepad.logic.LogicProvider;
import by.itacademy.lessen26.notepad.logic.NotebookLogic;

import java.util.List;

public class FindByContentCommand implements Command {
    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final NotebookLogic logic = logicProvider.getNotebookLogic();

    @Override
    public String execute(String request) {

        String response = "";
        String[] params;
        List<Note> notesByContent;

        params = request.split("\n");
        notesByContent = logic.find(params[1]);

        for (Note n : notesByContent) {
            response = response + n.toString();
        }
        return response;
    }
}

