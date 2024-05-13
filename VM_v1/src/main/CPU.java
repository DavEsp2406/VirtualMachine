package main;

public class CPU {
	public OperandStack pila;
	public Memory memoria;
	public boolean halt;

	public CPU() {
		this.pila = new OperandStack();
		this.memoria = new Memory();
		this.halt = false;
	}

	public String toString() {
		return null;
	}

	public void erase() {
		this.pila = new OperandStack();
		this.memoria = new Memory(); 
	}
	
	public boolean runCPU() {
		return this.halt = false;
	}

	public boolean sumaPila() {
		int n1 = pila.pop();
		int n2 = pila.pop();

		if (!(n1 == -1 && n2 == -1)) {
			this.pila.push(n1 + n2);
			return true;
		} else {
			return false;
		}
	}

	public boolean restaPila() {
		int n1 = pila.pop();
		int n2 = pila.pop();

		if (!(n1 == -1 && n2 == -1)) {
			this.pila.push(n1 - n2);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean mulPila() {
		int n1 = pila.pop();
		int n2 = pila.pop();

		if (!(n1 == -1 && n2 == -1)) {
			this.pila.push(n1 * n2);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean divPila() {
		int n1 = pila.pop();
		int n2 = pila.pop();

		if ((n1 != -1 || n2 != -1) || (n1 != 0 || n2 != 0)) {
			this.pila.push(n1 / n2);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean getCima() {
		System.out.println("Entero almacenado en la cima de la pila: " + this.pila.getCima());
		return true;
		
	}
	
	public boolean Halt() {
		return this.halt == true;
	}
	
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
			if(this.memoria.write(instr.getParam(), this.pila.pop()))
			break;
		case ADD:
			if(this.sumaPila()) {
				exc = true;
			}
			break;
		case SUB:
			if(this.restaPila()) {
				exc = true;
			}
			break;
		case MUL:
			if(this.mulPila()) {
				exc = true;
			}
			break;
		case DIV:
			if(this.divPila()) {
				exc = true;
			}
			break;
		case OUT:
			if (this.getCima()) {
				exc = true;
			}
			break;
		case HALT:
			if(this.Halt()) {
				exc = true;
			}
			break;
		}
		return exc;
	}
	
	//PUSH(1), LOAD(1), STORE(1), ADD, SUB, MUL, DIV, OUT, HALT;

	/*
	 * tiene una pila(array) de tipo OPERANDSTACK y tambien tiene un atributo que se
	 * llama memoria de tipo Memory y tambien tiene un boolean que sera la condicion
	 * de parada, una constructora , tambien tiene un metodo toString el cual hará
	 * llamada al metodo toString de OperandStack y al de memory.
	 * 
	 * Tienen un metodo llamado erase el cual borra la pila y la memoria, tiene otro
	 * metodo que retorna un booleano que dice si esta vacio o no, como empty
	 * (hall). sumaPila, restaPila, multiplicaPila, dividePila (4 metodos), hay que
	 * tener en cuenta varios inconvenientes ya que se puede dividir entre 0, sumar
	 * solo un numero etc..
	 * 
	 * sumaPila se puede hacer con pop, pop y push. Si no se puede hay que volver a
	 * meter el numero y dar un mensaje de error (es booleano)
	 * 
	 * runCPU, si hall es true entonces significa que esta parada
	 * 
	 * metodo execute de cpu, recibe un bytecde por parametro y procede a ejecutarle
	 */
}
