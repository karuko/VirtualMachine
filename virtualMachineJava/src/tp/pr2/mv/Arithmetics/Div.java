package tp.pr2.mv.Arithmetics;

import tp.pr2.mv.Instructions.Instruction;
import tp.pr2.mv.Exceptions.ExceptionDivisionByZero;



// TODO: Auto-generated Javadoc
/**
 * The Class Div.
 */

public class Div extends Arithmetics {

	
	/* (non-Javadoc)
	 * @see tp.pr2.mv.Arithmetics.Arithmetics#execute(int, int)
	 */
	public void execute(int n1, int n2)  {
		
		if(n1 == 0)  
			throw new ExceptionDivisionByZero();
		
		this.result = n2/n1;
		
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "DIV";
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.Instructions.Instruction#parse(java.lang.String[])
	 */
	public Instruction parse(String[] s) 
	{
		if (s.length==1 && s[0].equalsIgnoreCase("DIV")) 
			return new Div();
		else 
			return null;
	}
}
