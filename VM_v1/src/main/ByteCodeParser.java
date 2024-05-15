package main;

import java.util.Arrays;

public class ByteCodeParser {
	/**
	 * Metodo para generar el bytecode a traves del string introducido
	 * @param s String introducido
	 * @return ByteCode generado
	 */
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
			}
		}
	return bc;
	}
}
