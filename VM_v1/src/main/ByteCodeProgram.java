package main;

public class ByteCodeProgram {
	/**
	 * Atributos
	 */
	public ByteCode program[];
	public ByteCode incprogram[];
	public int numElems;
	public int size;
	/**
	 * Constructora
	 */
	public ByteCodeProgram() {
		this.numElems = 0;
		this.size = 10;
		this.program = new ByteCode[size];
	}
	/**
	 * metodo que sirve para construir el string cuando se hace run
	 * @param cpu recive cpu para poder hacer llamada al metodo halt y parar
	 * @return String Cadena que va a devolver con el string construido
	 */
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
	/**
	 * Metodo que sirve para borrar todas las instrucciones del array
	 * @return true si se ha ejecutado correctamente
	 */
	public boolean erase() {
		this.program = new ByteCode[this.size];
		this.numElems = 0;
		return true;
	}
	/**
	 * Metodo que sirve para reemplazar una instruccion 
	 * @param bc bytecode instroducido
	 * @param _pos posicion de la instruccion que va a ser reemplazada
	 * @return true si se ha ejecutado correctamente
	 */
	public boolean setInstructionPos(ByteCode bc, int _pos) {
		if (!(_pos >= this.size)) {
			program[_pos] = bc;
			return true;
		} else {
			return false;
		}
	}
	/**
	 * metodo para introducir una instruccion en el array
	 * @param _bytecode introducido
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
	/**
	 * metodo que sirve para agrandar el tamaño del array si la posicion de la instruccion sobrepasa
	 * el limite
	 */
	private void resize() {
		this.incprogram = new ByteCode[size * 2];
		this.size *= 2;
		for (int i = 0; i < this.program.length; i++) {
			this.incprogram[i] = program[i];
		}
		this.program = this.incprogram;
	}
	/**
	 * Metodo toString que devuelve un string con la posicion de la instruccion y la instruccion
	 * @return String 
	 */
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
}
