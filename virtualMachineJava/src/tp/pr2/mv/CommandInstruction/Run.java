package tp.pr2.mv.CommandInstruction;

// TODO: Auto-generated Javadoc
/**
 * The Class Run.
 */
public class Run extends Step {

    /* (non-Javadoc)
     * @see tp.pr2.mv.CommandInstruction.Step#executeCommand()
     */
    public void executeCommand() {
        
        
        while (!cpu.abortComputation()) {
        	
        		cpu.step();
//                printStateMachine();
        }
      
    }

    /* (non-Javadoc)
     * @see tp.pr2.mv.CommandInstruction.Step#parser(java.lang.String[])
     */
    public CommandInt parser(String[] s) {
        
        if (s.length == 1 && s[0].equalsIgnoreCase("RUN")) {
            return new Run();
        }
        else
        	return null;
        
    }
}
