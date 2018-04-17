package tp.pr2.mv.Arithmetics;

import tp.pr2.mv.Instructions.Instruction;


// TODO: Auto-generated Javadoc
/**
 * The Class Sub.
 */
public class Sub extends Arithmetics {

	/* (non-Javadoc)
	 * @see tp.pr2.mv.Arithmetics.Arithmetics#execute(int, int)
	 */
	public void execute(int n1, int n2) {
		this.result = n2-n1;
		
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "SUB";
	}

	
	/* (non-Javadoc)
	 * @see tp.pr2.mv.Instructions.Instruction#parse(java.lang.String[])
	 */
	public Instruction parse(String[] s) {
		if (s.length==1 && s[0].equalsIgnoreCase("SUB")) 
			return new Sub();
		else 
			return null;
	}
	
}
