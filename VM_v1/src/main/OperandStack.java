package main;

public class OperandStack {
	final int MAX_STACK = 10;
	private int[] stack;
	private int num_elems;

	public OperandStack() {
		this.stack = new int[MAX_STACK];
		this.num_elems = 0;
	}
	/**
	 * Metodo booleano para saber si la pila esta vacia o no
	 * @return true si esta vacia, false si tiene elementos
	 */
	public boolean isEmpty() {
		return this.num_elems == 0;
	}
	/**
	 * Metodo toString que retorna la pila en String
	 */
	public String toString() {
		String chain = "";
		if (this.isEmpty() == true) {
			return "<Vacia>";
		} else {
			for (int i = 0; i < this.num_elems; i++) {
				chain += stack[i] + " ";
			}
			return chain;
		}
	}
	/**
	 * Metodo que nos permite introducir valores en la pila
	 * @param n valor a introducir
	 * @return false si la pila esta llena, true si se puede introducir el valor
	 */
	public boolean push(int n) {
		if (this.num_elems >= this.MAX_STACK) {
			return false;
		} else {
			this.stack[this.num_elems] = n;
			this.num_elems++;
			return true;
		}
	}
	/**
	 * Metodo que devuelve la ultima posicion de la pila y la elimina, si no hay
	 * nada devuelve -1
	 * @return el ultimo valor de la pila
	 */
	public int pop() {
		int lastPos;

		if (this.isEmpty() == true) {
			return -1;
		} else {
			lastPos = this.stack[this.num_elems - 1];
			this.num_elems--;
			return lastPos;
		}
	}
	/**
	 * Metodo que devuelve la ultima posicion de la pila, si no hay nada devuelve -1 
	 * @return el ultimo valor de la pila
	 */
	public int getCima() {
		if (this.isEmpty() == true) {
			return -1;
		} else {
			return this.stack[this.num_elems - 1];
		}
	}
}
