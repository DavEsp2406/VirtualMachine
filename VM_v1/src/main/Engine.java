package main;

import java.util.Scanner;

public class Engine {
	Scanner sc = new Scanner(System.in);

	public void start() {
		/*
		 * String opc = ""; do { opc = sc.next(); switch (opc.toLowerCase()) { case
		 * "help":
		 * System.out.println("HELP \nQUIT \nRUN \nNEWINST BYTECODE \nRESET \nREPLACE");
		 * break; case "quit": System.out.println("adios chacho"); break; case "RUN":
		 * System.out.println("chucha"); break; case "newinst":
		 * System.out.println("chucha"); break; case "reset":
		 * System.out.println("chucha"); break; case "replace":
		 * System.out.println("chucha"); break; } }while (opc.toLowerCase() != "quit");
		 */

		OperandStack uwu = new OperandStack();

		uwu.push(4);
		uwu.push(6);
		uwu.push(2);
		System.out.println(uwu.toString());
		

	}
}
