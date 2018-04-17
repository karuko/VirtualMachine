package tp.pr2.mv.RestSeq;

import tp.pr2.mv.Exceptions.ExceptionNegativeDirection;
import tp.pr2.mv.Exceptions.ExceptionOperand;
import tp.pr2.mv.Instructions.Instruction;
import tp.pr2.mv.VirtualMachine.CPU;


// TODO: Auto-generated Javadoc
/**
 * The Class StoreInd.
 */
public class StoreInd extends RestSeq {
	
	
	/**
	 * Constructora.
	 */
	public StoreInd() {
		
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
             int cima = cpu.pop();
             if(cima < 0 ) throw new ExceptionNegativeDirection();
             cpu.getMemory().setValue(cima, value);
              
         }
		
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "STOREIND ";
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.Instructions.Instruction#parse(java.lang.String[])
	 */
	public Instruction parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("STOREIND")) 
			return new StoreInd();
		else 
			return null; 
	}

}
