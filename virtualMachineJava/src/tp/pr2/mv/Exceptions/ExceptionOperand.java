package tp.pr2.mv.Exceptions;

// TODO: Auto-generated Javadoc
/**
 * The Class ExceptionOperand.
 */
@SuppressWarnings("serial")
public class ExceptionOperand extends RuntimeException {
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	public String getMessage(){
		String mensaje = " Faltan operandos en la pila ";
		return mensaje;
			
		}
		
	
}
