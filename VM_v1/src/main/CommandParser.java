package main;

import java.util.Arrays;

public class CommandParser {
	public static Command parse(String line) {
		//esta clase sirve para averiguar que comando a introducido el usuario y devolverlo 
		//como un comando para la clase engine
		
		String[] cmdArray = line.split(" ");//se hace un split y se guarda en un array
		
		Command cmd = null;
		
		if(cmdArray.length == 1) {
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
			switch(cmdArray[1].toLowerCase()) {
			}
		}
		
		
		return null;
	
		/*
		 * hacer lo mismo que en la clase parser de byte code (la clase recibia un array 
		 * y se hacia un split y luego se iba comprobado por las partes divididas) pero ahora
		 * lo que hay que adivinar que comando se esta introduciendo. que comandos hay?
		 * help, run, quit, si fuese longitud 2 podria ser newinst o replace y si 
		 * tiene longitudd 3 newinst push 1
		 */
		
	}
}
