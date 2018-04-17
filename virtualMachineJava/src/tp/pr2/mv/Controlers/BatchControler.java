package tp.pr2.mv.Controlers;

import tp.pr2.mv.Exceptions.ExceptionDivisionByZero;
import tp.pr2.mv.Exceptions.ExceptionNegativeDirection;
import tp.pr2.mv.Exceptions.ExceptionOperand;
import tp.pr2.mv.VirtualMachine.CPU;

// TODO: Auto-generated Javadoc
/**
 * The Class BatchControler.
 */
public class BatchControler extends Controler {

	/**
	 * Instantiates a new batch controler.
	 *
	 * @param cpu the cpu
	 */
	public BatchControler(CPU cpu) {
		super(cpu);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.Controlers.Controler#start()
	 */
	@Override
	public void start() {
		try{
			cpu.run();
		}catch(ExceptionOperand e){
			
		}catch(ExceptionNegativeDirection e){
			
		}catch(ExceptionDivisionByZero e){
			
		}
	}

}
