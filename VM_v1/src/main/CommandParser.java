package main;

import java.util.Arrays;

public class CommandParser {
	/**
	 * metodo para la construccion del comando
	 * @param line string que mete el usuario por consola
	 * @return del comando construido
	 */
	public static Command parse(String line) {
		String[] cmdArray = line.split(" ");//se hace un split y se guarda en un array
		
		Command cmd = null;
		
		if(cmdArray.length == 0) {
			return cmd;
		}else if(cmdArray.length == 1) {
			switch(cmdArray[0].toLowerCase()) {
				case "help":
					cmd = new Command(ENUM_COMMAND.HELP);
					break;
				case "quit":
					cmd = new Command(ENUM_COMMAND.QUIT);
					break;
				case "run":
					cmd = new Command(ENUM_COMMAND.RUN);
					break;
				case "reset":
					cmd = new Command(ENUM_COMMAND.RESET);
					break;
			}
		}else if(cmdArray.length == 2) {
			switch(cmdArray[0].toLowerCase()) {
				case "newinst":
					cmd = new Command(ENUM_COMMAND.NEWINST, ByteCodeParser.parse(cmdArray[1]));
					break;
				case "replace":
					cmd = new Command(ENUM_COMMAND.REPLACE, Integer.parseInt(cmdArray[1]));
				}
		}else if(cmdArray.length == 3) {
			switch(cmdArray[0].toLowerCase()) {
			case "newinst":
				cmd = new Command(ENUM_COMMAND.NEWINST, ByteCodeParser.parse(cmdArray[1] + " " + cmdArray[2]));
				break;
			}
		}
		return cmd;
	}
}