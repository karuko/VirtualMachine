package tp.pr2.mv.Exceptions;

// TODO: Auto-generated Javadoc
/**
 * The Class ExceptionNegativeNumber.
 */
@SuppressWarnings("serial")
public class ExceptionNegativeNumber extends RuntimeException {
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	public String getMessage(){
		String s = "Error division por negativo";
		return s;
		
	}
	
}