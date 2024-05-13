package main;

public class Memory {
	final int MAX_MEMORY = 10;
	private Integer[] memory;
	private Integer[] incmemory;
	public boolean empty;
	/**
	 * Constructora
	 */
	public Memory() {
		this.memory = new Integer[this.MAX_MEMORY];
		this.empty = true;
	}
	/**
	 * Metodo que convierte los valores de la memoria a una cadena String
	 */
	public String toString() {
		String chain = "";
		
		if(this.empty == true) {
			chain += "<Vacia>";
		}else {
			for (int i = 0; i < this.memory.length; i++) {
				if(this.memory[i] != null) {
					chain += "[" + i + "]:" + this.memory[i] + "  ";
				}	
			}
		}	
		return chain;
	}
	/**
	 * Este metodo lo que hace es ver si se puede escribir un valor en una posicion, 
	 * si se puede lo escribe y si no puede llama a resize 
	 * @param _pos posicion en la que queremos introducir el nuevo valor
	 * @param _value valor a introducir
	 * @return
	 */
	public boolean write(int _pos, int _value) {
		this.empty = false;
		if(_pos >= 0) {
			if(_pos >= this.MAX_MEMORY) {
				this.resize(_pos);
				this.memory[_pos] = _value;
			}else {
				this.memory[_pos] = _value;
			}
		}
		return true;	
	}
	/**
	 * Metodo que lee el valor de una determinada posicion
	 * @param _pos posicion del valor que queremos leer
	 * @return del valor que se encuentra en _pos o -1 si la posición es null
	 */
	public Integer read(int _pos) {
		if(this.memory[_pos] == null) {
			return -1;
		}else {
			return this.memory[_pos];
		}
	}
	/**
	 * Metodo que duplica el tamaño del array si el valor a introducir supera la maxima
	 * posicion
	 * @param _pos posicion del valor que se va a introducir
	 * @return memory con tamaño pos * 2
	 */
	private void resize(int _pos) {
		this.empty = false;
		this.incmemory = new Integer[_pos * 2];
		
		for(int i = 0; i < this.memory.length; i++) {
			this.incmemory[i] = memory[i];
		}
		this.memory = this.incmemory;
	}
}
