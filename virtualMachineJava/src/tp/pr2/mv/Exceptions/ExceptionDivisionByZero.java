package tp.pr2.mv.Exceptions;

// TODO: Auto-generated Javadoc
/**
 * The Class ExceptionDivisionByZero.
 */
@SuppressWarnings("serial")
public class ExceptionDivisionByZero extends RuntimeException {
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	public String getMessage(){
		String s = "Error division por 0";
		return s;
		
	}
}
