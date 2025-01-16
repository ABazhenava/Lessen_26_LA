package by.itacademy.lessen26.notepad.logic;

import by.itacademy.lessen26.notepad.logic.impl.NotebookLogicImpl;

public final class LogicProvider {
	private static final LogicProvider instance = new LogicProvider();

	private LogicProvider() {}

	private NotebookLogic logic = new NotebookLogicImpl();

	public NotebookLogic getNotebookLogic() {
		return logic;
	}

	public static LogicProvider getInstance() {
		return instance;
	}

	}
