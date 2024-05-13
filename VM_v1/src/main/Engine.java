package main;

import java.util.Scanner;

public class Engine {
	private ByteCodeProgram program;
	private boolean end;
	Scanner sc = new Scanner(System.in);

	
	public void start() {
        System.out.println("Comienza el programa VIRTUAL MACHINE\r\n");
        help();
        do {
            this.entrada = this.sc.nextLine();
            this.cmd = CommandParser.parse(this.entrada);
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
}
