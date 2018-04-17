package tp.pr2.mv.CommandInstruction;



// TODO: Auto-generated Javadoc
/**
 * The Class Quit.
 */
public class Quit extends Step {
	
    /* (non-Javadoc)
     * @see tp.pr2.mv.CommandInstruction.Step#executeCommand()
     */
    public void executeCommand() {
        cpu.isFinish();
    }

   
    /**
     * Parseo de quit.
     *
     * @param s string
     * @return the commandint
     */
    public CommandInt parser(String[] s) {
        
        if (s.length == 1 && s[0].equalsIgnoreCase("QUIT")) {
            return new Quit();
        }
        else
        	return null;
    }
}