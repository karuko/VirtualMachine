package tp.pr2.mv.CommandInstruction;

import tp.pr2.mv.VirtualMachine.CPU;

// TODO: Auto-generated Javadoc
/**
 * The Class CommandInt.
 */
abstract public class CommandInt 
{
	
	/** Isfinished. */
	protected boolean isFinished;
	
	/** La cpu. */
	protected static CPU cpu;
	
	/**
	 * Constructora.
	 */
	public CommandInt()
	{
		this.isFinished = false;
	}
	
	/**
	 * Configure command int.
	 *
	 * @param cpu la cpu
	 */
	public static void configureCommandInt(CPU cpu)
	{
		CommandInt.cpu = cpu;
	}
	
	/**
	 * Metod abstracto de la ejecucion de los comandos.
	 *
	 * @return true si se resuelve correctamente
	 */
	public abstract void executeCommand(); 
	
	/**
	 * Comprueba si se ha finalizado.
	 *
	 * @return true, si se ha finalizado correctamente
	 */
	public boolean isFinished()
	{
		return this.isFinished = true;
	}
	
	/**
	 * Muestra el estado de la maquina virtual.
	 */
	public static void printStateMachine() {
//		if(cpu.ModeBatch != true)
        System.out.println( cpu.toString());
    }
	
	/**
	 * Parseo del CommandInterpreter.
	 *
	 * @param s the s
	 * @return the commandint
	 */
	public abstract CommandInt parser(String[] s);
}
