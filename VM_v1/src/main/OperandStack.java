package main;

public class OperandStack {
	final int MAX_STACK = 10;
	private int[] stack;
	private int num_elems;

	public OperandStack() {
		this.stack = new int[MAX_STACK];
		this.num_elems = 0;
	}

	public String toString() {
		String chain = "";
		for (int i = 0; i < this.num_elems; i++) {
			chain += stack[i];
		}
		return chain;
	}

	public boolean isEmpty() {
		return this.num_elems == 0;
	}

	public boolean push(int n) {
		if (this.num_elems >= this.MAX_STACK) {
			return false;
		}else {
			this.stack[this.num_elems] = n;
			this.num_elems++;
			return true;	
		}
	}
	
	
	public void load(int _pos) {
		Memory mm = new Memory();
		this.stack[this.num_elems] = mm.read(_pos);;
		this.num_elems++;
	}
	/**
	 * Metodo que devuelve la ultima posicion de la pila y la elimina, si 
	 * no hay nada devuelve -1
	 * @return
	 */
	public int pop() {
		int lastPos;
		
		if(this.isEmpty() == true) {
			return -1;
		}else {
			lastPos = this.stack[this.num_elems - 1];
			this.num_elems--;
			return lastPos;
		}
	}
	/**
	 * Metodo que devuelve la ultima posicion de la pila, si no hay nada devuelve -1
	 * @return
	 */
	public int getCima() {
		if(this.isEmpty() == true) {
			return -1;
		}else {
			return this.stack[this.num_elems - 1];
		}
		
	}
}
