package main;

public class OperandStack {
	final int MAX_STACK = 10;
	private int[] stack;
	private int num_elems;
	public int value;

	public OperandStack() {
		this.stack = new int[MAX_STACK];
		this.num_elems = 0;
		this.value = 0;
	}

	public String toString() {
		String chain = "";
		for (int i = 0; i < this.num_elems; i++) {
			chain += stack[i];
		}
		return chain;
	}

	public boolean isEmpty() {
		if (this.num_elems == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void push(int n) {
		this.stack[this.num_elems] = n;
		this.num_elems++;
	}

	public int pop() {
		this.value = this.stack[this.num_elems - 1];
		this.stack[this.num_elems - 1] = 0;
		this.num_elems--;
		return this.value;
	}
	
	public int peek() {
		this.value = this.stack[this.num_elems - 1];	
		return this.value;
	}
}
