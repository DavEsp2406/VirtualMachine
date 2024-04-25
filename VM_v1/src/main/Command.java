package main;

import java.util.Iterator;

public class Command {
	private ENUM_COMMAND command;
	private ByteCode instruction;
	private int replace;
	
	
	public Command(ENUM_COMMAND CMD) {
		this.command = CMD;
	}
	
	public Command(ByteCode BC, ENUM_COMMAND CMD) {
		this.instruction = BC;
		this.command = CMD;
	}
	
	public boolean execute(Engine engine) {
		this.command.getValueArg();
		
		return false;
		
		
	}
}
