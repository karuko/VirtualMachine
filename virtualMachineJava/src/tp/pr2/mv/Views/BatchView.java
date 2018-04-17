package tp.pr2.mv.Views;

import tp.pr2.mv.Instructions.Instruction;
import tp.pr2.mv.VirtualMachine.CPUObserver;
import tp.pr2.mv.VirtualMachine.Memory;
import tp.pr2.mv.VirtualMachine.Observable;
import tp.pr2.mv.VirtualMachine.OperandStack;
import tp.pr2.mv.VirtualMachine.ProgramMv;

// TODO: Auto-generated Javadoc
/**
 * The Class BatchView.
 */
public class BatchView implements CPUObserver{

	
	
	/**
	 * Instantiates a new batch view.
	 *
	 * @param cpu the cpu
	 */
	public BatchView(Observable<CPUObserver> cpu) {
		cpu.addObserver(this);
	 }
	
	
	/* (non-Javadoc)
	 * @see tp.pr2.mv.VirtualMachine.CPUObserver#onStartInstrExecution(tp.pr2.mv.Instructions.Instruction)
	 */
	@Override
	public void onStartInstrExecution(Instruction instr) {
		
		
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.VirtualMachine.CPUObserver#onEndInstrExecution(int, tp.pr2.mv.VirtualMachine.OperandStack, tp.pr2.mv.VirtualMachine.Memory)
	 */
	@Override
	public void onEndInstrExecution(int pc, OperandStack<Integer> stack, Memory<Integer> memory) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.VirtualMachine.CPUObserver#onStartRun()
	 */
	@Override
	public void onStartRun() {
		//Desactivar botones
		
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.VirtualMachine.CPUObserver#onEndRun()
	 */
	@Override
	public void onEndRun() {
		//Activar botones
		
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.VirtualMachine.CPUObserver#onError(java.lang.String)
	 */
	@Override
	public void onError(String msg) {
		System.err.println(msg);
		
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.VirtualMachine.CPUObserver#onHalt()
	 */
	@Override
	public void onHalt() {
		
		
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.VirtualMachine.CPUObserver#onReset(tp.pr2.mv.VirtualMachine.ProgramMv)
	 */
	@Override
	public void onReset(ProgramMv program) {
		// TODO Auto-generated method stub
		
	}

	
}
