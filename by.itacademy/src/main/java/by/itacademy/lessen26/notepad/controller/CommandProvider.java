package by.itacademy.lessen26.notepad.controller;

import by.itacademy.lessen26.notepad.controller.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    public CommandProvider() {
        repository.put(CommandName.ADD, new AddNoteCommand());
        repository.put(CommandName.UPDATE, new UpdateNoteCommand());
        repository.put(CommandName.FINDBYDATE, new FindByDateCommand());
		repository.put(CommandName.DISPLAY, new DisplayNotesCommand());
        repository.put(CommandName.WRONG_REQUEST, new NoSuchCommand());
        repository.put(CommandName.FINDBYCONTENT, new FindByContentCommand());
    }

    public Command getCommand(String name) {
        CommandName commandName = null;
        Command command = null;

        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            //write log
            command = repository.get(CommandName.WRONG_REQUEST);
        }
        return command;
    }
}
