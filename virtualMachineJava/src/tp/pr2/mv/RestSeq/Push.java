package tp.pr2.mv.RestSeq;

import tp.pr2.mv.Instructions.Instruction;
import tp.pr2.mv.VirtualMachine.CPU;
import tp.pr2.mv.VirtualMachine.Number;

// TODO: Auto-generated Javadoc
/**
 * The Class Push.
 */
public class Push extends RestSeq {

	/** The n. */
	private int n;
	
	/**
	 * Constructora.
	 *
	 * @param n the n
	 */
	public Push(int n)
	{
		this.n = n;
	}
	
	/**
	 * Constructora.
	 */
	public Push(){
	
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.RestSeq.RestSeq#executeAux(tp.pr2.mv.VirtualMachine.CPU)
	 */
	public void executeAux(CPU cpu) {
		cpu.push(n);
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "PUSH "+ n;
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.Instructions.Instruction#parse(java.lang.String[])
	 */
	public Instruction parse(String[] s) {
		if (s.length == 2 && s[0].equalsIgnoreCase("PUSH") && Number.isNumber(s[1]))
			return new Push(Integer.parseInt(s[1]));
		else 
			return null; 
	}
}
