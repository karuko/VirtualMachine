package tp.pr2.mv.RestSeq;

import tp.pr2.mv.Instructions.Instruction;
import tp.pr2.mv.VirtualMachine.CPU;

// TODO: Auto-generated Javadoc
/**
 * The Class Halt.
 */
public class Halt extends RestSeq {

    /* (non-Javadoc)
     * @see tp.pr2.mv.RestSeq.RestSeq#executeAux(tp.pr2.mv.VirtualMachine.CPU)
     */
    protected void executeAux(CPU cpu) 
    {
    	cpu.isFinish();
    	
    }

 
    /* (non-Javadoc)
     * @see tp.pr2.mv.Instructions.Instruction#parse(java.lang.String[])
     */
    public Instruction parse(String[] s) 
    {
        if (s.length == 1 && s[0].equalsIgnoreCase("HALT")) 
           return new Halt();
        else 
        	return null;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString(){
        return "HALT";
    }
}
