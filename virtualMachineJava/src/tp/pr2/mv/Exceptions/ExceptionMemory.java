package tp.pr2.mv.Exceptions;

// TODO: Auto-generated Javadoc
/**
 * The Class ExceptionMemory.
 */
@SuppressWarnings("serial")
public class ExceptionMemory extends RuntimeException {

	/** The pos. */
	int pos;
	
	/**
	 * Instantiates a new exception memory.
	 *
	 * @param pos the pos
	 */
	public ExceptionMemory(int pos){
		this.pos = pos;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	public String getMessage(){
		return "Error: Invalid Memory Acces in position: " + this.pos;
	}
}
