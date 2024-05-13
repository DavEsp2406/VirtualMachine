package main;

import java.util.Scanner;

public class Engine {
	private ByteCodeProgram program;
	private Command cmd;
	private boolean end;
	private CPU cpu;
	Scanner sc;

	public Engine(){
		this.program = new ByteCodeProgram();
		this.cmd = new Command();
		this.cpu = new CPU();
		this.sc = new Scanner(System.in);
		this.end = false;
	}
	
	
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
                    System.err.println("Error: Ejecución incorrecta del comando.\r\n");
                }
            } else {
                System.err.println("Error: Comando incorrecto.\r\n");
            }
        } while (!this.end); 
    }
	
	
	
	public boolean help() {
		System.out.println("HELP: Muestra esta ayuda" + 
		"\nQUIT: Cierra la aplicacion"
		+ "\nRUN: Ejecuta el programa"
		+ "\nNEWINST BYTECODE: Introduce una nueva instrucción al programa"
		+ "\nRESET: Vacia el programa actual"
		+ "\nREPLACE N: Reemplaza la instruccion N por la solicitada el usuario");
		return true;
	}
	
	public boolean quit() {
		System.out.println(this.program.toString() + "Fin de la ejecucion....");
		this.end = true;
		return true;
	}
	
	public boolean run() {
		System.out.println(this.program.runProgram(this.cpu) + this.program.toString());
		return true;
	}
	
	public boolean newinst(ByteCode btc) {
		if(btc != null) {
			this.program.setInstruction(btc);
			System.out.println(this.program.toString());
			return true;	
		}
		return false;
	}
	
	public boolean reset() {
		this.program.erase();
		return true;
	}
	
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
