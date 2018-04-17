package tp.pr2.mv.VirtualMachine;

import tp.pr2.mv.Instructions.Instruction;

// TODO: Auto-generated Javadoc
/**
 * An asynchronous update interface for receiving notifications
 * about CPU information as the CPU is constructed.
 */
public interface CPUObserver {
	
	/**
	 * This method is called when information about an CPU
	 * which was previously requested using an asynchronous
	 * interface becomes available.
	 *
	 * @param instr the instr
	 */
	public void onStartInstrExecution(Instruction instr);
	
	/**
	 * This method is called when information about an CPU
	 * which was previously requested using an asynchronous
	 * interface becomes available.
	 *
	 * @param pc the pc
	 * @param stack the stack
	 * @param memory the memory
	 */
	public void onEndInstrExecution(int pc, OperandStack<Integer> stack, Memory<Integer> memory);
	
	/**
	 * This method is called when information about an CPU
	 * which was previously requested using an asynchronous
	 * interface becomes available.
	 */
	public void onStartRun();
	
	/**
	 * This method is called when information about an CPU
	 * which was previously requested using an asynchronous
	 * interface becomes available.
	 */
	public void onEndRun();
	
	/**
	 * This method is called when information about an CPU
	 * which was previously requested using an asynchronous
	 * interface becomes available.
	 *
	 * @param msg the message
	 */
	public void onError(String msg);
	
	/**
	 * This method is called when information about an CPU
	 * which was previously requested using an asynchronous
	 * interface becomes available.
	 */
	public void onHalt();
	
	/**
	 * This method is called when information about an CPU
	 * which was previously requested using an asynchronous
	 * interface becomes available.
	 *
	 * @param program the program
	 */
	public void onReset(ProgramMv program);
	
}
