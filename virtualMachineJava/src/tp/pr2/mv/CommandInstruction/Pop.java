package tp.pr2.mv.CommandInstruction;

import tp.pr2.mv.Exceptions.ExceptionOperand;

// TODO: Auto-generated Javadoc
/**
 * The Class Pop.
 */
public class Pop extends CommandInt {

	/* (non-Javadoc)
	 * @see tp.pr2.mv.CommandInstruction.CommandInt#executeCommand()
	 */
	@Override
	public void executeCommand() {
		if(cpu.getSizeStack() == 0) 
			throw new ExceptionOperand();
		
        else
        	cpu.pop();
			
        
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.CommandInstruction.CommandInt#parser(java.lang.String[])
	 */
	@Override
	public CommandInt parser(String[] line) {
		
		if (line.length == 1 && line[0].equalsIgnoreCase("POP")) 
            return new Pop();
        else
        	return null;
	}

}
