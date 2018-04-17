package tp.pr2.mv.Views;

import tp.pr2.mv.Instructions.Instruction;
import tp.pr2.mv.VirtualMachine.CPUObserver;
import tp.pr2.mv.VirtualMachine.Memory;
import tp.pr2.mv.VirtualMachine.Observable;
import tp.pr2.mv.VirtualMachine.OperandStack;
import tp.pr2.mv.VirtualMachine.ProgramMv;

// TODO: Auto-generated Javadoc
/**
 * The Class InteractiveView.
 */
public class InteractiveView implements CPUObserver {

	/** The Constant NEWLINE. */
	public static final String NEWLINE = System.getProperty("line.separator");
	
	/**
	 * Instantiates a new interactive view.
	 *
	 * @param cpu the cpu
	 */
	public InteractiveView(Observable<CPUObserver> cpu){
		cpu.addObserver(this);
	}
	
	/* (non-Javadoc)
	 * @see tp.pr2.mv.VirtualMachine.CPUObserver#onStartInstrExecution(tp.pr2.mv.Instructions.Instruction)
	 */
	@Override
	public void onStartInstrExecution(Instruction instr) {
		
		System.out.println("Comienza la ejecucion de: " + instr);

	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.VirtualMachine.CPUObserver#onEndInstrExecution(int, tp.pr2.mv.VirtualMachine.OperandStack, tp.pr2.mv.VirtualMachine.Memory)
	 */
	@Override
	public void onEndInstrExecution(int pc, OperandStack<Integer> stack, Memory<Integer> memory) {
		
		System.out.println(NEWLINE + "Estado de la máquina tras ejecutar la instrucción es: "+ NEWLINE 
		 + memory.toString() + NEWLINE + stack.toString() + NEWLINE);
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.VirtualMachine.CPUObserver#onStartRun()
	 */
	@Override
	public void onStartRun() {
		
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.VirtualMachine.CPUObserver#onEndRun()
	 */
	@Override
	public void onEndRun() {
		
		System.out.println("Fin del programa");
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
		
		
	}

}
