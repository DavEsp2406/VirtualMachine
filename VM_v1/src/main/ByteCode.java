package main;

public class ByteCode {
	private ENUM_BYTECODE name;
	private int param;
	
	public ByteCode(ENUM_BYTECODE bc) {
		this.name = bc;
	}
	
	public ByteCode(ENUM_BYTECODE bc, int n) {
		this.name = bc;
		this.param = n;
	}
	
	public ENUM_BYTECODE getByteCode() {
		return this.name;
	}
	
	public int getParam() {
		return this.param;
	}
}


/*
	se necesitan 2 constructoras, 1 para cuando no tiene parametro y otra para cuando si tiene
	
	2 metodos (getParam, getByteCode)
 */