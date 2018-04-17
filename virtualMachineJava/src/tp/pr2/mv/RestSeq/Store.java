package tp.pr2.mv.RestSeq;

import tp.pr2.mv.Exceptions.ExceptionNegativeDirection;
import tp.pr2.mv.Exceptions.ExceptionOperand;
import tp.pr2.mv.Instructions.Instruction;
import tp.pr2.mv.VirtualMachine.CPU;
import tp.pr2.mv.VirtualMachine.Number;

// TODO: Auto-generated Javadoc
/**
 * The Class Store.
 */
public class Store extends RestSeq {

	/** The pos. */
	private int pos;
	
	/**
	 * Constructora.
	 *
	 * @param pos the pos
	 */
	public Store(int pos)
	{
		this.pos = pos;
	}
	
	
	/**
	 * Constructora.
	 */
	public Store() {
		
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.RestSeq.RestSeq#executeAux(tp.pr2.mv.VirtualMachine.CPU)
	 */
	public void executeAux(CPU cpu) {
		
		if(cpu.getSizeStack() == 0) /*si no hay nada no puede hacerlo*/
			throw new ExceptionOperand();
		
		 else
         { 
             int value = cpu.pop(); 
             if(pos < 0)
            	 throw new ExceptionNegativeDirection();
             cpu.getMemory().setValue(pos, value);
             
             
         }
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "STORE " + pos;
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.Instructions.Instruction#parse(java.lang.String[])
	 */
	public Instruction parse(String[] s) {
		if (s.length == 2 && s[0].equalsIgnoreCase("STORE") && Number.isNumber(s[1])) 
			return new Store(Integer.parseInt(s[1]));
		else 
			return null; 
	}
}
