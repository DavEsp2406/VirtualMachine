package main;

public class Memory {
	final int MAX_MEMORY = 10;
	private Integer[] memory;
	public int size;
	public boolean empty;
	
	public Memory() {
		this.size = 0;
	}
	/**
	 * Metodo que convierte los valores de la memoria a una cadena String
	 */
	public String toString() {
		//hay que añadir tambien la posicion a parte del valor, si está vacia se pone "vacia"
		String chain = "";
		for (int i = 0; i < this.size; i++) {
			chain += memory[i];
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
		//hay que comprobar que la posicion sea mayor a 0
		//this.resize(pos)
		this.memory[_pos] = _value;
		if(_pos <= this.memory.length) {
			return true;
		}else {
			return false;
		}	
	}
	/**
	 * Metodo que lee el valor de una determinada posicion
	 * @param _pos posicion del valor que queremos leer
	 * @return
	 */
	public Integer read(int _pos) {
		//si no hay ningun dato en la posicion pos se devuelve -1
		_pos = this.memory[_pos];
		return _pos;
	}
	/**
	 * Metodo que duplica el tamaño del array si el valor a introducir supera la maxima
	 * posicion
	 * @param _pos
	 * @return
	 */
	private void resize(int _pos) {
		//pone la variable empty a false, porque si a resize lo llama el metodo write significa que se va escribir algo en el array, por lo que significa que ya no va a estar vacio y empty pasa a false
		//si la posicion es >= que this.size, hay que aumentar el tamaño al doble (pos*2)
		//this.memory = array2;
		
	}
}
