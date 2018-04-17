package tp.pr2.mv.VirtualMachine;

import tp.pr2.mv.Exceptions.CmdLineException;

// TODO: Auto-generated Javadoc
/**
 * The Class Options.
 */
public class Options {
	
	/** The asm. */
	private final String asm = "-a";
	
	/** The help. */
	private final String help = "-h";
	
	/** The in. */
	private final String in = "-i";
	
	/** The mode. */
	private final String mode = "-m";
	
	/** The out. */
	private final String out = "-o";
	
	/** The a. */
	private String a;
	
	/** The h. */
	private Boolean h;
	
	/** The i. */
	private String i;
	
	/** The m. */
	private String m;
	
	/** The o. */
	private String o;
	
	/**
	 * Gets the a.
	 *
	 * @return the a
	 */
	public String getA(){ return a;}
	
	/**
	 * Gets the h.
	 *
	 * @return the h
	 */
	public Boolean getH(){ return h;}
	
	/**
	 * Gets the i.
	 *
	 * @return the i
	 */
	public String getI(){ return i;}
	
	/**
	 * Gets the m.
	 *
	 * @return the m
	 */
	public String getM(){ return m;}
	
	/**
	 * Gets the o.
	 *
	 * @return the o
	 */
	public String getO(){ return o;}
	
	/**
	 * Parses the.
	 *
	 * @param args the args
	 */
	public void parse (String[] args){
		a = i = o = null;
		h = null;
		m = "batch";
		int j = 0;
		
		while (j < args.length){
			
			if(args[j].equals(asm)){
				j++;
				if(j == args.length) throw new CmdLineException("Uso incorrecto: Fichero ASM no especificado. Use -h|--help para más detalles.");
				a = args[j];
				j++;
			}
				
			else if(args[j].equals(help)){
				h = true;
				j++;
			}
			else if(args[j].equals(in)){
				j++;	
				if(j == args.length) throw new CmdLineException("Uso incorrecto: Missing argument for option: i Use -h|--help para más detalles.");
				i = args[j] ;
				j++;
			}
			else if(args[j].equals(mode)){
				j++;
				m = args[j] ;
				j++;
			}
			else if(args[j].equals(out)){
				j++;
				if(j == args.length) throw new CmdLineException("Uso incorrecto: Missing argument for option: o Use -h|--help para más detalles.");
				o = args[j] ;
				j++;
			}
			else {
				validate();
			}
						
	}
		
		
}
	
	/**
	 * Validate.
	 */
	private void validate() {
		if(i != null)
			throw new CmdLineException("Uso incorrecto: Missing argument for option: i Use -h|--help para más detalles.");
		if(o != null)
			throw new CmdLineException("Uso incorrecto: Missing argument for option: o Use -h|--help para más detalles.");
		if(a != null)
			throw new CmdLineException("Uso incorrecto: Fichero ASM no especificado. Use -h|--help para más detalles.");
		else 
			throw new CmdLineException("Uso incorrecto: Comando desconocido. Use -h|--help para más detalles.");

		
	}

	
	
}
