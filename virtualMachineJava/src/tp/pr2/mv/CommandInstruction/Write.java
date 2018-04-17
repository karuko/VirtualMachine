package tp.pr2.mv.CommandInstruction;

import tp.pr2.mv.VirtualMachine.Number;

// TODO: Auto-generated Javadoc
/**
 * The Class Write.
 */
public class Write extends CommandInt {

	/** The v. */
	private int n, v;
	
	/**
	 * Instantiates a new write.
	 */
	public Write() {
		
	}
	
	/**
	 * Instantiates a new write.
	 *
	 * @param pos the pos
	 * @param value the value
	 */
	public Write (int pos, int value){
		this.n = pos;
		this.v = value;
		
	}
	
	
	/* (non-Javadoc)
	 * @see tp.pr2.mv.CommandInstruction.CommandInt#executeCommand()
	 */
	@Override
	public void executeCommand() {
		
		cpu.getMemory().setValue(n, v);

	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.CommandInstruction.CommandInt#parser(java.lang.String[])
	 */
	@Override
	public CommandInt parser(String[] s) {
		 if (s.length == 3 && s[0].equalsIgnoreCase("WRITE") && Number.isNumber(s[1]) && Number.isNumber(s[2])) 
	            return new Write(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
	        else	
	        	return null;
	}

}
