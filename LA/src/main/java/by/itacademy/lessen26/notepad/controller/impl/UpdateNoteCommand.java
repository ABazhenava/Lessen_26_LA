package by.itacademy.lessen26.notepad.controller.impl;

import by.itacademy.lessen26.notepad.controller.Command;
import by.itacademy.lessen26.notepad.entity.Note;
import by.itacademy.lessen26.notepad.logic.LogicProvider;
import by.itacademy.lessen26.notepad.logic.NotebookLogic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateNoteCommand implements Command {
    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final NotebookLogic logic = logicProvider.getNotebookLogic();

    @Override
    public String execute(String request) {
        String response = null;
        String[] params;
        Note newNote;

        params = request.split("\n");
        newNote = new Note();

        newNote.setId(Integer.parseInt(params[1].split("=")[1]));
        newNote.setTitle(params[2].split("=")[1]);
        newNote.setContent(params[3].split("=")[1]);

        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("yyyy-mm-dd");
        Date date;
        try {
            date = format.parse(params[4].split("=")[1]);
            newNote.setD(date);

            logic.add(newNote);
            response = "Запись была обновлена успешно.";
        } catch (ParseException e) {
            e.printStackTrace();
            response = "Запись не обновлена.";
//		} catch(LogicException e) {
//			throw new LogicException("Error adding note: " + e.getMessage(), e);
//
        }
        return response;
    }
}
