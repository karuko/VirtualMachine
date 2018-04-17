package tp.pr2.mv.Jumps;

import tp.pr2.mv.Exceptions.ExceptionOperand;
import tp.pr2.mv.Instructions.Instruction;
import tp.pr2.mv.VirtualMachine.CPU;

// TODO: Auto-generated Javadoc
/**
 * The Class RJumps.
 */
abstract public class RJumps implements Instruction {
	
	/** The n. */
	protected int n;
	
	/**
	 * Jump.
	 *
	 * @param cima the cima
	 * @return true, si se resuelve correctamente
	 */
	abstract protected boolean Rjump(int cima);
	
	/**
	 * Constructora.
	 */
	protected RJumps(){
		
	}
	
	/**
	 * Constructora.
	 *
	 * @param n el numero de la posicion a la que saltar
	 */
	protected RJumps(int n) {
        this.n = n;
    }
	
	/**
	 * Ejecucion de las instrucciones de salto.
	 *
	 * @param cpu the cpu
	 */
	public void execute(CPU cpu) 
	{
		 
	        if (cpu.getSizeStack() > 0) 
	        {
	            int cima = cpu.pop(); 
	            
	            if (this.Rjump(cima)) 
	                cpu.RJumpCpu(n);
	            
	            else 
	            	cpu.increaseProgramCounter();
	            
	        }
	        else 
	        	throw new ExceptionOperand();
	       
	}
}

