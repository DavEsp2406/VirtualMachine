package main;

import java.util.Scanner;

public class Engine {
	/**
	 * Atributos
	 */
	private ByteCodeProgram program;
	private Command cmd;
	private boolean end;
	private CPU cpu;
	public Scanner sc;
	/**
	 * Constructora
	 */
	public Engine(){
		this.program = new ByteCodeProgram();
		this.cmd = new Command();
		this.cpu = new CPU();
		this.sc = new Scanner(System.in);
		this.end = false;
	}
	
	/**
	 * Método start, se encarga de leer los comandos introducidos por el usuario,
	 * hasta recibir quit.
	 */
	public void start() {    
        do {
            this.cmd = CommandParser.parse(this.sc.nextLine());
            if (this.cmd != null) {
                if (this.cmd.getByteCode() != null) {
                    System.out.println("Comienza la ejecución de " + this.cmd.getCommand() + " " + this.cmd.getByteCode());
                } else {
                    System.out.println("Comienza la ejecución de " + this.cmd.getCommand());
                }
                if (!this.cmd.execute(this)) {
                    System.err.println("Error: Ejecución incorrecta del comando.\n");
                }
            } else {
                System.err.println("Error: Comando incorrecto.\n");
            }
        } while (!this.end); 
    }
	/**
	 * Muestra información sobre los distintos comandos disponibles
	 * @return true si el comando se ha ejecutado correctamente
	 */
	public boolean help() {
		System.out.println("HELP: Muestra esta ayuda" + 
		"\nQUIT: Cierra la aplicacion"
		+ "\nRUN: Ejecuta el programa"
		+ "\nNEWINST BYTECODE: Introduce una nueva instrucción al programa"
		+ "\nRESET: Vacia el programa actual"
		+ "\nREPLACE N: Reemplaza la instruccion N por la solicitada el usuario");
		return true;
	}
	/**
	 * Metodo para cerrar la aplicación
	 * @return true si el comando se ha ejecutado correctamente
	 */
	public boolean quit() {
		System.out.println(this.program.toString() + "Fin de la ejecucion....");
		this.end = true;
		return true;
	}
	/**
	 * Metodo para ejecutar el programa actual, en caso de error avisa al usuario mediante un mensaje
	 * @return true si el comando se ha ejecutado correctamente
	 */
	public boolean run() {
		System.out.println(this.program.runProgram(this.cpu) + this.program.toString());
		return true;
	}
	/**
	 * Metodo para introducir la instruccion bytecode bc al programa actual
	 * @param btc bytecode introducido despues de newinst
	 * @return true si el comando se ha ejecutado correctamente
	 */
	public boolean newinst(ByteCode btc) {
		if(btc != null) {
			this.program.setInstruction(btc);
			System.out.println(this.program.toString());
			return true;	
		}
		return false;
	}
	/**
	 * Metodo para inicializar el programa actual eliminando todas las instrucciones
	 * almacenadas
	 * @return true si el comando se ha ejecutado correctamente
	 */
	public boolean reset() {
		this.program.erase();
		return true;
	}
	/**
	 * Metodo que solicita al usuario una nueva instruccion BC, que en caso de ser correcta
	 * reemplazara a la instruccion bytecode numero n del programa
	 * @param _pos posicion del comando que va a ser remplazado
	 * @return true si el comando se ha ejecutado correctamente
	 */
	public boolean replace(int _pos) {
		if(_pos < this.program.numElems) {
			System.out.println("Nueva instrucción");
			ByteCode btc = ByteCodeParser.parse(this.sc.nextLine());
			this.program.setInstructionPos(btc, _pos);
			System.out.println(this.program.toString());
			
			return true;
		}
			return false;
	}
}
