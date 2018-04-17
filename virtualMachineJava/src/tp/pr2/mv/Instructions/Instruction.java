package tp.pr2.mv.Instructions;

import tp.pr2.mv.VirtualMachine.CPU;

// TODO: Auto-generated Javadoc
/**
 * The Class Instruction.
 */
 public interface Instruction {
	
	/**
	 * Execute.
	 *
	 * @param cpu the cpu
	 * @return true, si se resuelve correctamente
	 */
	abstract public void execute(CPU cpu);
	
	/**
	 * Parseo de la instruccion.
	 *
	 * @param s the s
	 * @return  instruction
	 */
	abstract public Instruction parse(String[] s);
}
