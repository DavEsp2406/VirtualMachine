package main;

public class ByteCodeProgram {
	public ByteCode program[];
	public ByteCode incprogram[];
	public int numElems;
	public int size;

	public ByteCodeProgram() {
		this.numElems = 0;
		this.size = 10;
		this.program = new ByteCode[size];
	}

	public String runProgram(CPU cpu) {
		String chain = "";
		for (int i = 0; i < this.numElems; i++) {
			if (!cpu.Halt() && cpu.execute(this.program[i])) {
				chain = chain + "El estado de la máquina tras ejecutar el bytecode " + this.program[i]
						+ " es:\n\nEstado de la CPU:\n" + cpu.toString() + "\n\n";
			} else if (!cpu.Halt()) {
				chain += "Error: Ejecucion incorrecta del comando" + "\n";
				this.program.toString();
				
			}
		}
		cpu.erase();
		cpu.runCPU();
		return chain;
	}

	public boolean erase() {
		this.program = new ByteCode[size];
		this.numElems = 0;
		return true;
	}

	public boolean setInstructionPos(ByteCode bc, int _pos) {
		if (!(_pos >= this.size)) {
			program[_pos] = bc;
			return true;
		} else {
			return false;
		}
	}

	/*
	 * public void setInstruction(ByteCode bc) { if (!(this.numElems >= this.size))
	 * { this.program[this.numElems] = bc; this.numElems++; } else { resize();
	 * this.program[this.numElems] = bc; this.numElems++; } }
	 */
	public void setInstruction(ByteCode _bytecode) {
		if (this.numElems >= this.size) {
			resize();
			this.program[numElems] = _bytecode;
			this.numElems++;
		} else {
			this.program[numElems] = _bytecode;
			this.numElems++;
		}
	}

	private void resize() {
		this.incprogram = new ByteCode[size * 2];
		this.size *= 2;
		for (int i = 0; i < this.program.length; i++) {
			this.incprogram[i] = program[i];
		}
		this.program = this.incprogram;
	}

	public String toString() {
		String chain = "";

		chain += "Programa almacenado:" + "\n";

		for (int i = 0; i < this.size; i++) {
			if (this.program[i] != null) {
				chain += i + ": " + this.program[i] + "\n";
			}

		}
		return chain;
	}

//tiene array de tipo ByteCode, que mete instrucciones como push 4 add, hall,... 
//el jony lo llama program
	/*
	 * tiene 2 atributos num_elems size, al igual que la memoria cuando se llena hay
	 * que hacer un resize
	 * 
	 * esta vez si se va a multiplicar por 2 el tamaño a diferencia de pos * 2 de
	 * memory
	 * 
	 * tiene otros metodos que son getters
	 * 
	 * tiene un metodo que devuelve la instruccion i-esima
	 * 
	 * boolean setInstructionPosition(bytecode, pos) tiene un metodo que inserta el
	 * bytecode bc en la posicion pos, sirve para hacer replace
	 * 
	 * void setInstruction(bytecode), diferencias con el de arriba: el primero
	 * inserta el bycecode en la posicon pos, mientras que este inserta el bc en la
	 * siguiente poscion que toque. Si no hay hueco hay que llamar a resize
	 * 
	 * Esta clase tiene tambien un metodo toString que lo que hace es imprimir
	 * Programa almacenado: 0: PUSH 2 1: PUSH 3 (pagina 5)
	 * 
	 * metodo runProgram: recorre todo el array y va ejecutando todas y cada una de
	 * las bytecode que hay en el array
	 * 
	 * 
	 * el array de bytecodes program va a tner de tamaño this.size = 1
	 * 
	 * 
	 * atributos: array bytecodes, size(long array), numelems(numero de elemntos en
	 * array)
	 * 
	 * String run program: recorrer hasta numelems del array(ejecuta tods los
	 * bytecodes del array). (devuelve un string) this.program[i].toString
	 * 
	 * 
	 * String runPromgram(CPU cpu)
	 * 
	 * crear un metodo para borrar el programa cuando se haga reset en engine. Lo
	 * que hace es borrar todos los elementos del array
	 */
}
