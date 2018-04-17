package tp.pr2.mv.RestSeq;

import tp.pr2.mv.Exceptions.ExceptionNegativeDirection;
import tp.pr2.mv.Instructions.Instruction;
import tp.pr2.mv.VirtualMachine.CPU;


// TODO: Auto-generated Javadoc
/**
 * The Class LoadInd.
 */
public class LoadInd extends RestSeq {

	/**
	 * Instantiates a new load ind.
	 */
	public LoadInd() {
		
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.RestSeq.RestSeq#executeAux(tp.pr2.mv.VirtualMachine.CPU)
	 */
	public void executeAux(CPU cpu) {
		
		int cima = cpu.pop();
		if(cima < 0) throw new ExceptionNegativeDirection();
		int x = cpu.getMemory().getValue(cima); //parseo
        cpu.push(x); 
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "LOADIND ";
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.Instructions.Instruction#parse(java.lang.String[])
	 */
	public Instruction parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("LOADIND")) 
			return new LoadInd();
		else return null; 
	}

}
