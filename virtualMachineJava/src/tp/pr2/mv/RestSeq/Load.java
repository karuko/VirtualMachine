package tp.pr2.mv.RestSeq;

import tp.pr2.mv.Exceptions.ExceptionNegativeDirection;
import tp.pr2.mv.Instructions.Instruction;
import tp.pr2.mv.VirtualMachine.CPU;
import tp.pr2.mv.VirtualMachine.Number;

// TODO: Auto-generated Javadoc
/**
 * The Class Load.
 */
public class Load extends RestSeq {

	
	/** The pos. */
	private int pos;

	/**
	 * Constructora.
	 *
	 * @param pos the pos
	 */
	public Load (int pos)
	{
		this.pos = pos;
	}
	
	/**
	 * Instantiates a new load.
	 */
	public Load() {
		
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.RestSeq.RestSeq#executeAux(tp.pr2.mv.VirtualMachine.CPU)
	 */
	public void executeAux(CPU cpu) {
		if (pos < 0) 
			throw new ExceptionNegativeDirection();
		
		int x = cpu.getMemory().getValue(pos); //parseo
        cpu.push(x); 
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "LOAD " + pos;
	}


	/* (non-Javadoc)
	 * @see tp.pr2.mv.Instructions.Instruction#parse(java.lang.String[])
	 */
	public Instruction parse(String[] s) {
		if (s.length == 2 && s[0].equalsIgnoreCase("LOAD") &&  Number.isNumber(s[1])) 
			return new Load(Integer.parseInt(s[1]));
		else return null; 
	}
}