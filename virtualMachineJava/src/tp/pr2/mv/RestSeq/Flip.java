package tp.pr2.mv.RestSeq;

import tp.pr2.mv.Exceptions.ExceptionOperand;
import tp.pr2.mv.Instructions.Instruction;
import tp.pr2.mv.VirtualMachine.CPU;

// TODO: Auto-generated Javadoc
/**
 * The Class Flip.
 */
public class Flip extends RestSeq {

	/* (non-Javadoc)
	 * @see tp.pr2.mv.RestSeq.RestSeq#executeAux(tp.pr2.mv.VirtualMachine.CPU)
	 */
	public void executeAux(CPU cpu) 
	{
		
		if(cpu.getSizeStack() < 2) /*si hay menos de 2 no puede hacerlo*/
			throw new ExceptionOperand();
        else
            { 
            int n1 = cpu.pop();/*coge los ultimos 2 numeros*/
            int n2 = cpu.pop(); 
              
            cpu.push(n1);/*y los mete al reves de como los saco*/
            cpu.push(n2);  
            
            
            }
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "FLIP";
	}

	
	/* (non-Javadoc)
	 * @see tp.pr2.mv.Instructions.Instruction#parse(java.lang.String[])
	 */
	public Instruction parse(String[] s) {
		if (s.length==1 && s[0].equalsIgnoreCase("FLIP")) 
			return new Flip();
		else return null; 
	}
}
