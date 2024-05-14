package main;

import java.util.Iterator;

public class Command {
	private ENUM_COMMAND command;
	private ByteCode instruction;
	private int replace;

	
	public Command() {
	}
	
	public Command(ENUM_COMMAND CMD) {
		this.command = CMD;
	}

	public Command(ENUM_COMMAND CMD, int replace) {
		this.command = CMD;
		this.replace = replace;
	}

	public Command(ENUM_COMMAND CMD, ByteCode BC) {
		this.command = CMD;
		this.instruction = BC;
	}

	public ENUM_COMMAND getCommand() {
		return this.command;
	}

	public ByteCode getByteCode() {
		return this.instruction;
	}

	public boolean execute(Engine engine) {
		boolean ext = false;

		switch (this.getCommand()) {
		case HELP:
			if (engine.help()) {
				ext = true;
			}
			break;
		case QUIT:
			if (engine.quit()) {
				ext = true;
			}
			break;
		case NEWINST:
			if (engine.newinst(this.instruction)) {
				ext = true;
			}
			break;
		case RUN:
			if (engine.run()) {
				ext = true;
			}
			break;
		
		case RESET:
			if (engine.reset()) {
				ext = true;
			}
			break;
		case REPLACE:
			if (engine.replace(this.replace)) {
				ext = true;
			}
			break;
		}
		return ext;

		}
	}