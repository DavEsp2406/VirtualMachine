package main;

import java.util.Iterator;


public class Command {
	private ENUM_COMMAND command;
	private ByteCode instruction;
	private int replace;//sirve para cuando se hace replace 3, recoger el 3 en el int :D
	

	public Command(ENUM_COMMAND CMD) {
		this.command = CMD;
	}
	
	public Command(ENUM_COMMAND CMD, int replace) {
		this.command = CMD;
		this.replace = replace;
		}
	
	public Command( ENUM_COMMAND CMD, ByteCode BC) {//se utiliza para los newinst ya que son un cmd seguido de btc
		this.command = CMD;
		this.instruction = BC;
	}
	
	public boolean execute(Engine engine) {
		this.command.getValueArg();
		return false;
	}
	/*
	 *tiene un if else con todos los comandos disponibles, que hace que si el comando es replace n
	 *por ejemplo, dice a engine que ejecute el comando replace
	 */
	
}

