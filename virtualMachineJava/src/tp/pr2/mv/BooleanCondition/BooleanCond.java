package tp.pr2.mv.BooleanCondition;

import tp.pr2.mv.Exceptions.ExceptionOperand;
import tp.pr2.mv.Instructions.Instruction;
import tp.pr2.mv.VirtualMachine.CPU;

// TODO: Auto-generated Javadoc
/**
 * The Class BooleanCond.
 */
abstract public class BooleanCond implements Instruction{
    
    /**
     * Metodo abstracto de las BooleanCond.
     *
     * @param cima la cima
     * @param subcima la subcima
     * @return true si se resuelve correctamente
     */
    protected abstract boolean ExecuteAux(int cima, int subcima);
    
    /* (non-Javadoc)
     * @see tp.pr2.mv.Instructions.Instruction#execute(tp.pr2.mv.VirtualMachine.CPU)
     */
    public void execute(CPU cpu) {
	
	if (cpu.getSizeStack() < 2) 
	{
		throw new ExceptionOperand();
	    
	}
	else
	{
		int cima = cpu.pop();
		int subcima = cpu.pop();
    
		if (ExecuteAux(cima, subcima)) 
			cpu.push(1);
    
		else 
			cpu.push(0);
    
		cpu.increaseProgramCounter();
	}
   }
}
