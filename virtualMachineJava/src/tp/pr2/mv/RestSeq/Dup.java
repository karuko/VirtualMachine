package tp.pr2.mv.RestSeq;

import tp.pr2.mv.Exceptions.ExceptionOperand;
import tp.pr2.mv.Instructions.Instruction;
import tp.pr2.mv.VirtualMachine.CPU;

// TODO: Auto-generated Javadoc
/**
 * The Class Dup.
 */
public class Dup extends RestSeq {

	
		/* (non-Javadoc)
		 * @see tp.pr2.mv.RestSeq.RestSeq#executeAux(tp.pr2.mv.VirtualMachine.CPU)
		 */
		public void executeAux(CPU cpu) {
			
			if(cpu.getSizeStack() == 0) /*si no hay nada no puede hacerlo*/
				throw new ExceptionOperand();
			
            else
            { 
                int n = cpu.pop(); /*si lo hay coger el ultimo numero*/
                cpu.push(n); /*y lo mete 2 veces*/
                cpu.push(n);  
                
            }
			
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		public String toString() {
			return "DUP";
		}

	
		/* (non-Javadoc)
		 * @see tp.pr2.mv.Instructions.Instruction#parse(java.lang.String[])
		 */
		public Instruction parse(String[] s) {
			if (s.length==1 && s[0].equalsIgnoreCase("DUP")) 
				return new Dup();
			else return null; 
	}
}

