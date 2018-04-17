package tp.pr2.mv.RestSeq;

import java.io.IOException;

import tp.pr2.mv.Exceptions.ExceptionNegativeDirection;
import tp.pr2.mv.Instructions.Instruction;
import tp.pr2.mv.VirtualMachine.CPU;

// TODO: Auto-generated Javadoc
/**
 * The Class RestSeq.
 */
abstract public class RestSeq implements Instruction {
	
	/**
	 * Execute aux.
	 *
	 * @param cpu the cpu
	 * @return true, si se resuelve correctamente
	 */
	abstract protected void executeAux(CPU cpu);

	/**
	 * Ejecucion de las instrucciones RestSeq.
	 *
	 * @param cpu the cpu
	 */
	public void execute(CPU cpu) 
	{	
			this.executeAux(cpu);
			cpu.increaseProgramCounter();
	
	}
}
