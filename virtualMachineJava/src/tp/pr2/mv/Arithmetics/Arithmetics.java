package tp.pr2.mv.Arithmetics;

import tp.pr2.mv.Exceptions.ExceptionDivisionByZero;
import tp.pr2.mv.Exceptions.ExceptionOperand;
import tp.pr2.mv.Instructions.Instruction;
import tp.pr2.mv.VirtualMachine.CPU;


// TODO: Auto-generated Javadoc
/**
 * The Class Arithmetics.
 */
abstract public class Arithmetics implements Instruction{
	
	/** resultado. */
	protected int result; 
	
	/**
	 * Execute.
	 *
	 * @param n1 the n1
	 * @param n2 the n2
	 * @return true
	 */
	abstract protected void execute(int n1, int n2);
	
	
	/* (non-Javadoc)
	 * @see tp.pr2.mv.Instructions.Instruction#execute(tp.pr2.mv.VirtualMachine.CPU)
	 */
	public void execute(CPU cpu)
	{
		
		if(cpu.getSizeStack() < 2 )
				throw new ExceptionOperand();
	
		else 
		{			 
			int n1 = cpu.pop();
			int n2 = cpu.pop();
			
			
			 this.execute(n1,n2);
			 cpu.push(this.result);
			 cpu.increaseProgramCounter();
			
		}
	 }	
}


