package tp.pr2.mv.Jumps;

import tp.pr2.mv.Instructions.Instruction;
import tp.pr2.mv.VirtualMachine.Number;


// TODO: Auto-generated Javadoc
/**
 * The Class Bf.
 */
public class Bf extends Jumps {

	/**
	 * Constructora.
	 *
	 * @param n the n
	 */
	protected Bf(int n) {
		super(n);
		
	}

	/**
	 * Constructora.
	 */
	public Bf() {
		
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.Jumps.Jumps#jump(int)
	 */
	public boolean jump(int cima) {
		
		if(cima == 0)
			return false;
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
		if (s.length == 2 && s[0].equalsIgnoreCase("BF") && Number.isNumber(s[1])) 
			return new Bf(Integer.parseInt(s[1]));
		
		else return null; 
	}
}
