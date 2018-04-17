package tp.pr2.mv.Jumps;

import tp.pr2.mv.Instructions.Instruction;
import tp.pr2.mv.VirtualMachine.Number;

// TODO: Auto-generated Javadoc
/**
 * The Class RBt.
 */
public class RBt extends RJumps {

	/**
	 * Constructora.
	 *
	 * @param n the n
	 */
	protected RBt(int n) {
		super(n);
		
	}

	/**
	 * Constructora.
	 */
	public RBt() {
		
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.Jumps.RJumps#Rjump(int)
	 */
	public boolean Rjump(int cima) {
		
		if(cima == 0)
			return false;
		else
			return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "RBT "+ n;
	}

	
	/* (non-Javadoc)
	 * @see tp.pr2.mv.Instructions.Instruction#parse(java.lang.String[])
	 */
	public Instruction parse(String[] s) {
		if (s.length == 2 && s[0].equalsIgnoreCase("RBT") && Number.isNumber(s[1])) 
			return new RBt(Integer.parseInt(s[1]));
		
		else return null; 
	}

	
}


