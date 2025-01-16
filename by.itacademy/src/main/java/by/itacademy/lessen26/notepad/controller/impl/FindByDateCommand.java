package by.itacademy.lessen26.notepad.controller.impl;

import by.itacademy.lessen26.notepad.controller.Command;
import by.itacademy.lessen26.notepad.entity.Note;
import by.itacademy.lessen26.notepad.logic.LogicProvider;
import by.itacademy.lessen26.notepad.logic.NotebookLogic;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FindByDateCommand implements Command {
    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final NotebookLogic logic = logicProvider.getNotebookLogic();

    @Override
    public String execute(String request) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        String response = "";
        String[] params;

        params = request.split("\n");

        try {
            for (Note n : logic.find(formatter.parse(params[1]))) {
                response = response + n.toString();
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return response;
    }
}

