package tp.pr2.mv.CommandInstruction;

import tp.pr2.mv.VirtualMachine.Number;

// TODO: Auto-generated Javadoc
/**
 * The Class Steps.
 */
public class Steps extends Step {

    /** The n. */
    private int n;

    /**
     * Constructora.
     */
    public Steps() {
    }

    /**
     * Constructora.
     *
     * @param num the num
     */
    public Steps(int num) {
        this.n = num;
    }
    
    /**
     *  
     * Ejecucion del comando.
     */
    public void executeCommand() 
    {
        boolean b = true;
        for (int i = 0; i < n && b; i++) {
              cpu.step();          
             //printStateMachine();
        }

        
    }

    /**
     *  
     * Parseo del interprete.
     *
     * @param s the s
     * @return the command int
     */
    public CommandInt parser(String[] s) {
        
        if (s.length == 2 && s[0].equalsIgnoreCase("STEP") && Number.isNumber(s[1])) 
            return new Steps(Integer.parseInt(s[1]));
        else	
        	return null;
    }
}