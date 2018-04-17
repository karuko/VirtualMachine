package tp.pr2.mv.BooleanCondition;

import tp.pr2.mv.Exceptions.ExceptionOperand;
import tp.pr2.mv.Instructions.Instruction;
import tp.pr2.mv.VirtualMachine.CPU;

// TODO: Auto-generated Javadoc
/**
 * The Class Not.
 */
public class Not implements Instruction {

    /**
     * ExecuteAux.
     *
     * @param cima la cima
     * @return true
     */
    protected boolean ExecuteAux(int cima) 
    {
        
        if (cima == 0) 
            return true;
        
        else 
        	return false;
    }


    /* (non-Javadoc)
     * @see tp.pr2.mv.Instructions.Instruction#parse(java.lang.String[])
     */
    public Instruction parse(String[] s) {
        
        if (s.length == 1 && s[0].equalsIgnoreCase("NOT")) {
            return new Not();
        }
        else
        	return null;
    }

    /* (non-Javadoc)
     * @see tp.pr2.mv.Instructions.Instruction#execute(tp.pr2.mv.VirtualMachine.CPU)
     */
    public void execute(CPU cpu) 
    {
        
        if (cpu.getSizeStack() < 1) 
        	throw new ExceptionOperand();
        else
        {
        	int cima = cpu.pop();
            
            if (ExecuteAux(cima)) 
                cpu.push(1);
            
            else 
                cpu.push(0);
            
            cpu.increaseProgramCounter();
        }
        	
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return "NOT";
    }
}
