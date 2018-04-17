package tp.pr2.mv.CommandInstruction;

import tp.pr2.mv.VirtualMachine.Number;

// TODO: Auto-generated Javadoc
/**
 * The Class Push.
 */
public class Push extends CommandInt {

	/** The n. */
	private int n;

	/**
	 * Instantiates a new push.
	 */
	public Push(){
		
	}
	
	/**
	 * Instantiates a new push.
	 *
	 * @param num the num
	 */
	public Push (int num){
		
		this.n = num;
	}
	
	/* (non-Javadoc)
	 * @see tp.pr2.mv.CommandInstruction.CommandInt#executeCommand()
	 */
	@Override
	public void executeCommand() {
		cpu.push(n);
		
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.CommandInstruction.CommandInt#parser(java.lang.String[])
	 */
	@Override
	public CommandInt parser(String[] s) {
		 if (s.length == 2 && s[0].equalsIgnoreCase("PUSH") && Number.isNumber(s[1])) 
	            return new Push(Integer.parseInt(s[1]));
	        else	
	        	return null;
	}

}
