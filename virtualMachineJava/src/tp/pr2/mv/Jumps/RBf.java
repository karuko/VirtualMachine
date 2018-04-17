package tp.pr2.mv.Jumps;

import tp.pr2.mv.Instructions.Instruction;
import tp.pr2.mv.VirtualMachine.Number;

// TODO: Auto-generated Javadoc
/**
 * The Class RBf.
 */
public class RBf extends RJumps {

	/**
	 * Constructora.
	 *
	 * @param n the n
	 */
	protected RBf(int n) {
		super(n);
		
	}

	/**
	 * Constructora.
	 */
	public RBf() {
		
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.Jumps.RJumps#Rjump(int)
	 */
	public boolean Rjump(int cima) {
		
		if(cima == 0)
			return true;
		else
			return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "BF "+ n;
	}

	
	/* (non-Javadoc)
	 * @see tp.pr2.mv.Instructions.Instruction#parse(java.lang.String[])
	 */
	public Instruction parse(String[] s) {
		if (s.length == 2 && s[0].equalsIgnoreCase("RBF") && Number.isNumber(s[1])) 
			return new Bf(Integer.parseInt(s[1]));
		
		else return null; 
	}

}
