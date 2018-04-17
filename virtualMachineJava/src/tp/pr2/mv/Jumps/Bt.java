package tp.pr2.mv.Jumps;


import tp.pr2.mv.Instructions.Instruction;
import tp.pr2.mv.VirtualMachine.Number;


// TODO: Auto-generated Javadoc
/**
 * The Class Bt.
 */
public class Bt extends Jumps {

	/**
	 * Constructora.
	 *
	 * @param n the n
	 */
	protected Bt(int n) {
		super(n);
		
	}

	/**
	 * Constructora.
	 */
	public Bt() {
		
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.Jumps.Jumps#jump(int)
	 */
	public boolean jump(int cima) {
		
		if(cima == 0)
			return true;
		else
			return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "BT "+ n;
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.Instructions.Instruction#parse(java.lang.String[])
	 */
	public Instruction parse(String[] s) {
		if (s.length == 2 && s[0].equalsIgnoreCase("BT")&& Number.isNumber(s[1])) 
			return new Bt(Integer.parseInt(s[1]));
		
		else return null; 
	}

	
}