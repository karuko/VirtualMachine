package tp.pr2.mv.NumericCond;

import tp.pr2.mv.Instructions.Instruction;

// TODO: Auto-generated Javadoc
/**
 * The Class Equal.
 */
public class Equal extends NumericCond 
{

	/* (non-Javadoc)
	 * @see tp.pr2.mv.NumericCond.NumericCond#compare(int, int)
	 */
	public boolean compare (int cima, int subcima)
	{
		if(subcima == cima)
			return true;
		
		else
			return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "EQ";
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.Instructions.Instruction#parse(java.lang.String[])
	 */
	public Instruction parse(String[] s) {
		
		if (s.length==1 && s[0].equalsIgnoreCase("EQ")) 
			return new Equal();
		return null;
	}
}
