package tp.pr2.mv.Jumps;


import tp.pr2.mv.Instructions.Instruction;
import tp.pr2.mv.VirtualMachine.CPU;
import tp.pr2.mv.VirtualMachine.Number;

// TODO: Auto-generated Javadoc
/**
 * The Class Jump.
 */
public class Jump implements Instruction
{
	
	/** The n. */
	private int n;
	
	/**
	 * Constructora.
	 *
	 * @param n the n
	 */
	public Jump(int n){
		this.n = n;
	}

	/**
	 * Constructora.
	 */
	public Jump() {

	}
	


	/**
	 * Salta al numero indicado.
	 *
	 * @param s the s
	 * @return true
	 */
	
	
	public Instruction parse(String[] s) {
	       
	       if (s.length == 2 && s[0].equalsIgnoreCase("JUMP") && Number.isNumber(s[1]))
	          return new Jump(Integer.parseInt(s[1])); 
	       else 
	    	   return null;
	    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
	       return "JUMP " + n;
	    }

	/* (non-Javadoc)
	 * @see tp.pr2.mv.Instructions.Instruction#execute(tp.pr2.mv.VirtualMachine.CPU)
	 */
	public void execute(CPU cpu) {
		
		cpu.JumpCpu(n);
		
	}

			
}
