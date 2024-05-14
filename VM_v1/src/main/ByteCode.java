package main;

public class ByteCode {
	/**
	 * Atributos
	 */
	private ENUM_BYTECODE name;
	private int param;
	/**
	 * Constructora
	 * @param bytecode que recive
	 */
	public ByteCode(ENUM_BYTECODE bc) {
		this.name = bc;
	}
	/**
	 * Constructora 
	 * @param bc bytecode que recibe
	 * @param n valor que recibe
	 */
	public ByteCode(ENUM_BYTECODE bc, int n) {
		this.name = bc;
		this.param = n;
	}
	/**
	 * metodo para devolver el bytecode
	 * @return del bytecode
	 */
	public ENUM_BYTECODE getByteCode() {
		return this.name;
	}
	/**
	 * metodo para devolver el parametro
	 * @return del parametro
	 */
	public int getParam() {
		return this.param;
	}
	/**
	 * metodo para toString para generar un string del bytecode
	 * @return del string
	 */
	public String toString() {
		String chain = "";

		if (this.name == ENUM_BYTECODE.PUSH || this.name == ENUM_BYTECODE.LOAD ||
				this.name == ENUM_BYTECODE.STORE) {
			chain += getByteCode() + " " + getParam();
		}else {
			chain += getByteCode();
		}
		return chain;
	}
}


