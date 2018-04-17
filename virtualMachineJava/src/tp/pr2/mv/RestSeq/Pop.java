package tp.pr2.mv.RestSeq;

import tp.pr2.mv.Exceptions.ExceptionOperand;
import tp.pr2.mv.Instructions.Instruction;
import tp.pr2.mv.VirtualMachine.CPU;

// TODO: Auto-generated Javadoc
/**
 * The Class Pop.
 */
public class Pop extends RestSeq {

	/* (non-Javadoc)
	 * @see tp.pr2.mv.RestSeq.RestSeq#executeAux(tp.pr2.mv.VirtualMachine.CPU)
	 */
	public void executeAux(CPU cpu) {
		
		if(cpu.getSizeStack() == 0) 
			throw new ExceptionOperand();
		
        else
        {
        	cpu.pop();
		
        }
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "POP";
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.Instructions.Instruction#parse(java.lang.String[])
	 */
	public Instruction parse(String[] s) {
		if (s.length==1 && s[0].equalsIgnoreCase("POP")) 
			return new Pop();
		else return null; 
}
}
