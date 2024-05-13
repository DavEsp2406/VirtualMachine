package main;


public class ByteCodeProgram {
	public ByteCode program [];
	public int numElems;
	public int size;
	
	
	public ByteCodeProgram() {
		
	}
	
	
	public String runProgram(CPU cpu) {
        String chain = "";
        for (int i = 0; i < this.numElems; i++) {
            if (!cpu.Halt() && cpu.execute(this.program[i])) {
                chain = chain  + "El estado de la máquina tras ejecutar el bytecode "
                        + this.program[i] + " es:\n\nEstado de la CPU:\n"
                        + cpu.toString() + "\n\n";
            } else if (!cpu.Halt()) {
                this.program.toString();
            }
        }
        cpu.erase();
        cpu.runCPU();
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
	 * Programa almacenado:
	 * 0: PUSH 2
	 * 1: PUSH 3 (pagina 5)
	 * 
	 * metodo runProgram: recorre todo el array y va ejecutando todas y cada una de las  
	 * bytecode que hay en el array 
	 * 
	 * 
	 * el array de bytecodes program va a tner de tamaño this.size = 1
	 * 
	 * 
	 * atributos: array bytecodes, size(long array), numelems(numero de elemntos en array)
	 * 
	 * String run program: recorrer hasta numelems del array(ejecuta tods los bytecodes del array).
	 * (devuelve un string)  this.program[i].toString
	 * 
	 * 
	 * String runPromgram(CPU cpu)
	 * 
	 * crear un metodo para borrar el programa cuando se haga reset en engine. Lo que hace es borrar
	 * todos los elementos del array 
	 */
}
