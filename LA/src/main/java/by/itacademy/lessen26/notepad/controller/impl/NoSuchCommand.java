package by.itacademy.lessen26.notepad.controller.impl;

import by.itacademy.lessen26.notepad.controller.Command;

public class NoSuchCommand implements Command {

	@Override
	public String execute(String request) {
		return "Ошибка запроса";
	}

}
