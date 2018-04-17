package tp.pr2.mv.RestSeq;

import java.io.IOException;
import tp.pr2.mv.Instructions.Instruction;
import tp.pr2.mv.VirtualMachine.CPU;

// TODO: Auto-generated Javadoc
/**
 * The Class In.
 */
public class In extends RestSeq {

	/* (non-Javadoc)
	 * @see tp.pr2.mv.RestSeq.RestSeq#executeAux(tp.pr2.mv.VirtualMachine.CPU)
	 */
	@Override
	protected void executeAux(CPU cpu){
				try {
					cpu.getOperandStack().push(cpu.getInStream().read());
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
	
	/* (non-Javadoc)
	 * @see tp.pr2.mv.Instructions.Instruction#parse(java.lang.String[])
	 */
	@Override
	public Instruction parse(String[] s) {
		if (s.length==1 && s[0].equalsIgnoreCase("IN")) 
			return new In();
		else 
			return null; 
		
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
	       return "IN";
	    }

	

}
