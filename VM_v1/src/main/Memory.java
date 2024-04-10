package main;

public class Memory {
	final int MAX_MEMORY = 10;
	private Integer[] memory;
	public int size;
	
	public Memory() {
		this.size = 0;
	}
	
	public String toString() {
		String chain = "";
		for (int i = 0; i < this.size; i++) {
			chain += memory[i];
		}
		return chain;
	}
	/**
	 * este metodo lo que hace es ver si se puede escribir en un valor en una posicion, 
	 * si se puede lo escribe y si no puede llama a resize 
	 * @param _pos
	 * @param _value
	 * @return
	 */
	public boolean write(int _pos, int _value) {
		this.memory[_pos] = _value;
			return false;
		
	}
	
	public Integer read(int _pos) {
		_pos = this.memory[_pos];
		return _pos;
	}
	
	private Integer resize(int _pos) {
		return MAX_MEMORY;
		
	}
}
