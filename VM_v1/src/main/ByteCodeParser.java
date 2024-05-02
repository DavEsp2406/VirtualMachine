package main;

import java.util.Arrays;

public class ByteCodeParser {
	public static ByteCode parse(String s) {
		String[] bcArray = s.split(" ");//se hace un split y se guarda en un array
		ByteCode bc = null;
		
		if(bcArray.length == 1) {
			switch(bcArray[0].toLowerCase()) {
				case "add":
					bc = new ByteCode(ENUM_BYTECODE.ADD);
					break;
				case "sub":
					bc = new ByteCode(ENUM_BYTECODE.SUB);
					break;
				case "mul":
					bc = new ByteCode(ENUM_BYTECODE.MUL);
					break;
				case "div":
					bc = new ByteCode(ENUM_BYTECODE.DIV);
					break;	
				case "out":
					bc = new ByteCode(ENUM_BYTECODE.OUT);
					break;
				case "halt":
					bc = new ByteCode(ENUM_BYTECODE.HALT);
					break;	
				default:
					System.out.println("Comando inválido");
			}
		}else if(bcArray.length == 2) {
			switch(bcArray[0]) {
				case "push":
					bc = new ByteCode(ENUM_BYTECODE.PUSH, Integer.parseInt(bcArray[1]));
					break;
				case "load":
					bc = new ByteCode(ENUM_BYTECODE.LOAD, Integer.parseInt(bcArray[1]));
					break;
				case "store":
					bc = new ByteCode(ENUM_BYTECODE.STORE, Integer.parseInt(bcArray[1]));
					break;
				default:
					System.out.println("Comando inválido");
			}
		}
	return bc;
	}
	
/*
 * recibe un string, que es algo que introduce el usuario, o cosas como newinst add 2, 
 * hall, etc... hay que particionar el string que entra por consola (hacer un split),
 * si el array tiene tamaño 0, el usuario es tremendo troll y devuelve null, si tiene
 * tamaño 1, hay que hacer un switch para cada una de esas posibilidades(hall, run, etc..), y si 
 * no es ninguna de esas palabras devuelve null, si es add  hay que crear un objeto 
 * bytecode de tipo add
 * return new ByteCode(Enum.add)
 * tamaño 2 es igual que el 1, si no es 0, 1 o 2 retornamos null
 * 
 * 
 * 
 */
}
