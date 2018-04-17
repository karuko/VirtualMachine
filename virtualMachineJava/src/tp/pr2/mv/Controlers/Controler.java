package tp.pr2.mv.Controlers;

import java.io.IOException;

import tp.pr2.mv.Exceptions.ExceptionOperand;
import tp.pr2.mv.MVSystem.InStrategy;
import tp.pr2.mv.MVSystem.OutStrategy;
import tp.pr2.mv.VirtualMachine.CPU;
import tp.pr2.mv.VirtualMachine.ProgramMv;


// TODO: Auto-generated Javadoc
/**
 * The Class Controler.
 */
public abstract class Controler {

	/** The cpu. */
	protected CPU cpu;
	
	/**
	 * Instantiates a new controler.
	 *
	 * @param cpu the cpu
	 */
	public Controler(CPU cpu){
		this.cpu = cpu;
	}
	
	/**
	 * Step.
	 */
	public void step(){
		try{
			cpu.step();
		}catch(Exception e){
			
		}
	}
	public void stepn(int n){
		try{
			cpu.stepn( n);
		}catch(Exception e){
			
		}
	}
	
	public void reset(){
		cpu.reset();
	}
	
	/**
	 * Run.
	 */
	public void run(){
		
		try{
			cpu.run();
		}catch(Exception e){
			
		}
	}
	
	/**
	 * Pop.
	 */
	public void pop(){
		try{
			cpu.pop();
		}catch(ExceptionOperand e){
			
		}
	}
	
	/**
	 * Push.
	 *
	 * @param v the v
	 */
	public void push(String v){
		try{
			cpu.push(new Integer(v));
		}catch(Exception e){
			
		}
	}
	
	/**
	 * Memory set.
	 *
	 * @param i the i
	 * @param v the v
	 */
	public void memorySet(String i, String v){
		try{
			cpu.setValue(new Integer(i), new Integer(v));
			
		}catch(NumberFormatException m){
			
		}
	
	}
	
	/**
	 * Gets the program.
	 *
	 * @return the program
	 */
	public ProgramMv getProgram(){
		return cpu.getProgram();
	}
	
	/**
	 * Sets the in stream.
	 *
	 * @param in the new in stream
	 */
	public void setInStream(InStrategy in){
		cpu.setInStream(in);
	}
	
	/**
	 * Gets the in stream.
	 *
	 * @return the in stream
	 */
	public InStrategy getInStream(){
		return cpu.getInStream();
		
	}
	
	/**
	 * Sets the out stream.
	 *
	 * @param out the new out stream
	 */
	public void setOutStream(OutStrategy out){
		cpu.setOutStream(out);
	}
	
	/**
	 * Gets the out stream.
	 *
	 * @return the out stream
	 */
	public OutStrategy getOutStream(){
		return cpu.getOutStream();
	}
	
	/**
	 * Pause.
	 */
	public void pause(){
		
	}
	
	/**
	 * Start.
	 */
	public abstract void start();
	
	/**
	 * Quit.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void quit() throws IOException{
		
		
		getOutStream().close();
		getInStream().close();
		System.exit(0);
		
		
	}
}
