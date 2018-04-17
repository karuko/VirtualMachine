package tp.pr2.mv.Exceptions;

// TODO: Auto-generated Javadoc
/**
 * The Class MVError.
 */
@SuppressWarnings("serial")
public class MVError extends RuntimeException {

	/** The s. */
	private String s;
	
	/**
	 * Instantiates a new cmd line exception.
	 *
	 * @param m the m
	 */
	public MVError(String m){
		this.s = m;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	public String getMessage(){
		return s;
		
	}
}