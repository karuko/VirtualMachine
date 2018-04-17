package tp.pr2.mv.CommandInstruction;

// TODO: Auto-generated Javadoc
/**
 * The Class CommandParser.
 */
public abstract class CommandParser {
	
	
	/** The Command set. */
	private static CommandInt CommandSet[] = {new Steps(), new Step(), new Run(), new Quit(), new Push(), new Pop(), new Write()};
	
	
	/**
	 * Parseo de comandos.
	 *
	 * @param line the line
	 * @return the commandint
	 */
	public static CommandInt parseCommand(String line)
	{
		
		CommandInt comint  = null;
        boolean stop = false;
        int i = 0;
        
        String[] components = line.split(" ");
        
        while (i < CommandParser.CommandSet.length && !stop) {
            comint = CommandParser.CommandSet[i].parser(components);
            
            if (comint != null) 
                stop = true;
            
            else 
                i++; 
        }
        return comint; 
						
	}
	
}
