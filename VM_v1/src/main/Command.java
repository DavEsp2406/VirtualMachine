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
	/*
	 * public boolean execute(ByteCode instr) { boolean exc = false;
	 * 
	 * switch(instr.getByteCode()) { case PUSH: if(this.pila.push(instr.getParam()))
	 * { exc = true; } break; case LOAD:
	 * if(this.pila.push(this.memoria.read(instr.getParam()))) { exc = true; }
	 * break; case STORE: if(this.memoria.write(instr.getParam(), this.pila.pop()))
	 * break; case ADD: if(this.sumaPila()) { exc = true; } break;
	 */
	/*
	 * tiene un if else con todos los comandos disponibles, que hace que si el
	 * comando es replace n por ejemplo, dice a engine que ejecute el comando
	 * replace
	 */

