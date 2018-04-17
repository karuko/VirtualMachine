package tp.pr2.mv.CommandInstruction;

// TODO: Auto-generated Javadoc
/**
 * The Class Step.
 */
public class Step extends CommandInt {


    /* (non-Javadoc)
     * @see tp.pr2.mv.CommandInstruction.CommandInt#executeCommand()
     */
    public void executeCommand() 
    {
         cpu.step();
//         printStateMachine();
       
    }

    /* (non-Javadoc)
     * @see tp.pr2.mv.CommandInstruction.CommandInt#parser(java.lang.String[])
     */
    public CommandInt parser(String[] line) {
        
        if (line.length == 1 && line[0].equalsIgnoreCase("STEP")) 
            return new Step();
        else
        	return null;
    }
}