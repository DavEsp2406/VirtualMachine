package main;

import java.util.Iterator;

public class Command {
	/**
	 * Atributos
	 */
	private ENUM_COMMAND command;
	private ByteCode instruction;
	private int replace;

	/**
	 * Constructora
	 */
	public Command() {
	}
	/**
	 * Constructora
	 */
	public Command(ENUM_COMMAND CMD) {
		this.command = CMD;
	}
	/**
	 * Constructora
	 */
	public Command(ENUM_COMMAND CMD, int replace) {
		this.command = CMD;
		this.replace = replace;
	}
	/**
	 * Constructora
	 */
	public Command(ENUM_COMMAND CMD, ByteCode BC) {
		this.command = CMD;
		this.instruction = BC;
	}
	/**
	 * metodo que retorna el comando
	 * @return el Enum command
	 */
	public ENUM_COMMAND getCommand() {
		return this.command;
	}
	/**
	 * metodo que retorna el bytecode
	 * @return del bytecode
	 */
	public ByteCode getByteCode() {
		return this.instruction;
	}
	/**
	 * metodo para comprobar la correcta ejecucion de los comandos 
	 * @param engine objeto de la clase engine 
	 * @return true si se ejecutan correctamente
	 */
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