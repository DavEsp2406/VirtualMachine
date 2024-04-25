package main;

import java.util.Arrays;

public class CommandParser {
	public static Command parse(String line) {
		
		String[] cmd = line.split(" ");//se hace un split y se guarda en un array
		
		switch(cmd.length) {
			case 0:
				System.out.println("Error comando inválido");
				break;
			case 1: 
				switch(cmd[0].toLowerCase()) {
					case "help":
						System.out.println("Si (づ￣ 3￣)づ");
						break;
					case "quit":
						System.out.println("(∪.∪ )...zzz");
						break;
					case "run":
						System.out.println("o(*￣▽￣*)ブ");
						break;
					case "reset":
						System.out.println("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧");
						break;
				}
				break;
			case 2:
				switch(cmd[1].toLowerCase()) {
					case "newinst":
						System.out.println("uwu");
						break;
					case "replace":
						System.out.println("uwu");
						break;
				}
			break;	
			default:
				System.out.println("wawa");
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
