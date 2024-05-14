package main;

public class CPU {
	/**
	 * Atributos
	 */
	public OperandStack pila;
	public Memory memoria;
	public boolean halt;
	/**
	 * constructora
	 */
	public CPU() {
		this.pila = new OperandStack();
		this.memoria = new Memory();
		this.halt = false;
	}
	/**
	 * metodo toString de CPU
	 * @return retorna el string con la cadena formada
	 */
	public String toString() {
		String chain = "";
		
		chain += "  Memoria: " + this.memoria.toString() + "\n  Pila: " + this.pila.toString();
		
		return chain;
	}
	/**
	 * metodo para vaciar la pila y la memoria
	 */
	public void erase() {
		this.pila = new OperandStack();
		this.memoria = new Memory(); 
	}
	/**
	 * metodo para correr el programa 
	 * @return halt false que hace que no pare el programa
	 */
	public boolean runCPU() {
		return this.halt = false;
	}
	/**
	 * metodo para sumar la pila
	 * @return suma de la pila
	 */
	public boolean sumaPila() {
        int num1 = this.pila.pop();
        int num2 = this.pila.pop();
        if (num1 == -1 || num2 == -1) {
            return false;
        }
        int add = num2 + num1;
        this.pila.push(add);
        return true;
    }
	/**
	 * metodo para restar la pila
	 * @return de la resta de la pila
	 */
	public boolean restaPila() {
		int n1 = pila.pop();
		int n2 = pila.pop();

		if (!(n1 == -1 || n2 == -1)) {
			int sub = n1 - n2;
			this.pila.push(sub);
			return true;
		} else {
			return false;
		}
	}
	/**
	 * metodo para multiplicar la pila 
	 * @return de la multiplicacion de pila
	 */
	public boolean mulPila() {
		int n1 = pila.pop();
		int n2 = pila.pop();

		if (!(n1 == -1 || n2 == -1)) {
			int mul = n1 * n2;
			this.pila.push(mul);
			return true;
		} else {
			return false;
		}
	}
	/**
	 * metodo para dividir la pila
	 * @return de la division de la pila
	 */
	public boolean divPila() {
		int n1 = pila.pop();
		int n2 = pila.pop();

		if (n1 == -1 || n2 == -1 || n1 == 0 || n2 == 0) {
			return false;
		}
		
		int div = n1/n2;
		this.pila.push(div);
		return true;
		
	}
	/**
	 * metodo para devolver la cima de la pila
	 * @return cima de la pila
	 */
	public boolean getCima() {
		System.out.println("Entero almacenado en la cima de la pila: " + this.pila.getCima());
		return true;	
	}
	/**
	 * metodo para parar la pila
	 * @return de halt
	 */
	public boolean Halt() {
		return this.halt;
	}
	/**
	 * metodo que ejecuta las instrucciones de cpu
	 * @param instr bytecode introducido
	 * @return true si se ejecuta correctamente el comando 
	 */
	public boolean execute(ByteCode instr) {
		boolean exc = false;
		
		switch(instr.getByteCode()) {
		case PUSH:
			if(this.pila.push(instr.getParam())) {
				exc = true;
			}
			break;
		case LOAD:
			if(this.pila.push(this.memoria.read(instr.getParam()))) {
				exc = true;
			}
			break;
		case STORE:
			if(this.memoria.write(instr.getParam(), this.pila.pop())) {
				exc = true;
			}
			break;
		case ADD:
			if(sumaPila()) {
				exc = true;
			}
			break;
		case SUB:
			if(restaPila()) {
				exc = true;
			}
			break;
		case MUL:
			if(mulPila()) {
				exc = true;
			}
			break;
		case DIV:
			if(divPila()) {
				exc = true;
			}
			break;
		case OUT:
			if (getCima()) {
				exc = true;
			}
			break;
		case HALT:
			if(!Halt()) {
				this.halt = true;
				exc = true;
			}
			break;
		}
		return exc;
	}
}
