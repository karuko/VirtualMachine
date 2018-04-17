package tp.pr2.mv.NumericCond;

import tp.pr2.mv.Exceptions.ExceptionOperand;
import tp.pr2.mv.Instructions.Instruction;
import tp.pr2.mv.VirtualMachine.CPU;


// TODO: Auto-generated Javadoc
/**
 * The Class NumericCond.
 */
abstract public class NumericCond implements Instruction 
{
	
	/**
	 * Compare.
	 *
	 * @param cima the cima
	 * @param subcima the subcima
	 * @return true, if successful
	 */
	protected abstract boolean compare(int cima, int subcima);

	/* (non-Javadoc)
	 * @see tp.pr2.mv.Instructions.Instruction#execute(tp.pr2.mv.VirtualMachine.CPU)
	 */
	public void execute(CPU cpu) 
	{
		if (cpu.getSizeStack()>=2)
		{
			
			int cima = cpu.pop();
			int subcima = cpu.pop();
			
			if (compare(cima,subcima)) cpu.push(1);
			else 
				cpu.push(0);
			
			cpu.increaseProgramCounter();
			
		}
		else 
			throw new ExceptionOperand();
	}
}
