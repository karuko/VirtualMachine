package tp.pr2.mv.RestSeq;

import java.io.IOException;

import tp.pr2.mv.Exceptions.ExceptionOperand;
import tp.pr2.mv.Instructions.Instruction;
import tp.pr2.mv.VirtualMachine.CPU;

// TODO: Auto-generated Javadoc
/**
	 * The Class Out.
	 */
	public class Out extends RestSeq {

		/* (non-Javadoc)
		 * @see tp.pr2.mv.RestSeq.RestSeq#executeAux(tp.pr2.mv.VirtualMachine.CPU)
		 */
		public void executeAux(CPU cpu)  {
			
			
			if(cpu.getSizeStack()==0) /*si no hay nada en la pila no se peude hacer*/
				throw new ExceptionOperand();
			
			else{
				
				int n = cpu.pop();
				if(n < 0) cpu.push(n);  
				
                 /*si es menor que 0 no tiene representacion, por lo que no se saca y se vuelve a meter en la pila*/
                else /* en caso contrario*/
                	{ 
                		char c = (char)(n); /* se convierte a char*/
                		try {
							cpu.getOutStream().write(c);
						} catch (IOException e) {
							e.printStackTrace();
						}  /*y se muestra por el archivo de salida*/
                   
                	}
				
			}
        }
			
		

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		public String toString() {
			return "OUT";
		}

		/* (non-Javadoc)
		 * @see tp.pr2.mv.Instructions.Instruction#parse(java.lang.String[])
		 */
		public Instruction parse(String[] s) {
			if (s.length==1 && s[0].equalsIgnoreCase("OUT")) 
				return new Out();
			else 
				return null; 
	}
}

