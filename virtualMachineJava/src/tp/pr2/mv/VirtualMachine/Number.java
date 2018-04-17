package tp.pr2.mv.VirtualMachine;

// TODO: Auto-generated Javadoc
/**
 * The Class Number.
 */
public abstract class Number 
{
		
	/**
	 * Checks if is number.
	 *
	 * @param line the line
	 * @return true, if is number
	 */
	public static boolean isNumber(String line)
	{
	        try 
	        {
	            Integer.parseInt(line);
	            return true;
	        } 
	        
	        catch (NumberFormatException nfe) {
	            return false;
	        }
	}
}
