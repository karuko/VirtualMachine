package tp.pr2.mv.Jumps;

import tp.pr2.mv.Exceptions.ExceptionOperand;
import tp.pr2.mv.Instructions.Instruction;
import tp.pr2.mv.VirtualMachine.CPU;

// TODO: Auto-generated Javadoc
/**
 * The Class JumpInd.
 */
public class JumpInd implements Instruction {

	/* (non-Javadoc)
	 * @see tp.pr2.mv.Instructions.Instruction#execute(tp.pr2.mv.VirtualMachine.CPU)
	 */
	@Override
	public void execute(CPU cpu) {
		 if (cpu.getSizeStack() > 0) 
	        {
	            int cima = cpu.pop(); 
	                cpu.JumpCpu(cima);
	           	            
	        }
		 else
			 throw new ExceptionOperand();
	            
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.Instructions.Instruction#parse(java.lang.String[])
	 */
	@Override
	public Instruction parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("JUMPIND"))
	          return new JumpInd(); 
	       else 
	    	   return null;
		
	}
	
	 /* (non-Javadoc)
 	 * @see java.lang.Object#toString()
 	 */
 	public String toString() {
	       return "JUMPIND ";
	    }
	
	
	
}
