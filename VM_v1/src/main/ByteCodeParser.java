package main;

import java.util.Arrays;

public class ByteCodeParser {
	
	public static ByteCode parse(String s) {
		String[] juji = s.split(" ");//se hace un split y se guarda en un array
		System.out.println(Arrays.asList(juji));
		
		switch(juji.length) {
			case 0:
				System.out.println("null");
				//return new ByteCode n = detipo null l :D
				break;
			case 1:	
				System.out.println("jojo");
				break;
			case 2:
				System.out.println("polla");
				break;
			case 3:
				System.out.println("awa");
				break;
		}
		if(juji.length == 1) {
			System.out.println("Te gusta el pene");
		}
		return null;
		//devuelveel bytecode almacenado en s o null si s no representa ningun comando
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
