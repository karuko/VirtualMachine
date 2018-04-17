package tp.pr2.mv.Arithmetics;

import tp.pr2.mv.Instructions.Instruction;

// TODO: Auto-generated Javadoc
/**
 * The Class Mul.
 */
public class Mul extends Arithmetics {

	
	/* (non-Javadoc)
	 * @see tp.pr2.mv.Arithmetics.Arithmetics#execute(int, int)
	 */
	public void execute(int n1, int n2) {
		this.result = n1*n2;
		
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "MUL";
	}

	
	/* (non-Javadoc)
	 * @see tp.pr2.mv.Instructions.Instruction#parse(java.lang.String[])
	 */
	public Instruction parse(String[] s) {
		if (s.length==1 && s[0].equalsIgnoreCase("MUL")) 
			return new Mul();
		else 
			return null;
	}
}
