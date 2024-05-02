package main;

import java.util.Scanner;

public class Engine {
	private ByteCodeProgram program;
	private boolean end;
	Scanner sc = new Scanner(System.in);

	
	
	public void start() {
		
		/*

		do {
			opc = sc.next();
			switch (opc.toLowerCase()) {
			case "help":
				this.menu();
				break;
			case "quit":
				System.out.println("adios chacho");
				break;
			case "run":
				System.out.println("chucha");
				break;
			case "newinst":
				System.out.println("chucha");
				break;
			case "reset":
				System.out.println("chucha");
				break;
			case "replace":
				System.out.println("chucha");
				break;
			}
		} while (!(opc.toLowerCase().equals("quit")));*/

		
	}

	public void menu() {
		System.out.println("HELP: Muestra esta ayuda \nQUIT: Cierra la aplicación"
				+ "\nRUN: Ejecuta el programa \nNEWINST BYTECODE: Introduce una nueva "
				+ "instrucción al programa \nRESET: Vacia el programa actual"
				+ "\nREPLACE N: Reemplaza la instrucción N por la solicitada al usuario");
	}
}
