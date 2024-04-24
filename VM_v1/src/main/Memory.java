package main;

public class Memory {
	final int MAX_MEMORY = 10;
	private Integer[] memory;
	private Integer[] incmemory;
	public int size;
	public boolean empty;
	
	
	public Memory() {
		this.memory = new Integer[this.MAX_MEMORY];
		this.size = 0;
		this.empty = true;
	}
	/**
	 * Metodo que convierte los valores de la memoria a una cadena String
	 */
	public String toString() {
		//hay que añadir tambien la posicion a parte del valor, si está vacia se pone "vacia"
		String chain = "";
		for (int i = 0; i < this.memory.length; i++) {
			if(this.memory[i] != null) {
				chain += "[" + i + "]:" + this.memory[i] + "  ";
			}	
		}
		return chain;
	}
	/**
	 * Este metodo lo que hace es ver si se puede escribir en un valor en una posicion, 
	 * si se puede lo escribe y si no puede llama a resize 
	 * @param _pos posicion en la que queremos introducir el nuevo valor
	 * @param _value valor a introducir
	 * @return
	 */
	public boolean write(int _pos, int _value) {
		boolean full;
		
		if(_pos >= 0) {
			if(_pos >= this.MAX_MEMORY) {
				this.resize(_pos);
				full = true;
			}else {
				this.memory[_pos] = _value;
				this.size++;
				full = false;
			}
		}else {
			full = false;
		}
		return full;	
	}
	/**
	 * Metodo que lee el valor de una determinada posicion
	 * @param _pos posicion del valor que queremos leer
	 * @return del valor que se encuentra en _pos o -1 si la posición es null
	 */
	public Integer read(int _pos) {
		if(this.memory[_pos]== null) {
			return -1;
		}else {
			return this.memory[_pos];
		}
	}
	/**
	 * Metodo que duplica el tamaño del array si el valor a introducir supera la maxima
	 * posicion
	 * @param _pos
	 * @return
	 */
	private void resize(int _pos) {
		//pone la variable empty a false, porque si a resize lo llama el metodo write 
		//significa que se va escribir algo en el array, por lo que significa que ya no va 
		//a estar vacio y empty pasa a false
		//si la posicion es >= que this.size, hay que aumentar el tamaño al doble (pos*2)
		//this.memory = array2;
		
		this.empty = false;
		incmemory = new Integer[_pos * 2];
		
		if(_pos >= this.size) {
			for(int i = 0; i <= this.MAX_MEMORY; i++) {
				if(this.memory[i] != null) {
					this.incmemory[i] = this.memory[i];
				}
			}
		}
	}
}
