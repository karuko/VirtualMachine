package tp.pr2.mv.MVSystem;

// TODO: Auto-generated Javadoc
/**
 * The Class OutStrategyNada.
 */
public class OutStrategyNada implements OutStrategy
{
	
	/* (non-Javadoc)
	 * @see tp.pr2.mv.MVSystem.OutStrategy#open()
	 */
	public void open() { }
	
	/* (non-Javadoc)
	 * @see tp.pr2.mv.MVSystem.OutStrategy#close()
	 */
	public void close() { }
	
	/* (non-Javadoc)
	 * @see tp.pr2.mv.MVSystem.OutStrategy#write(int)
	 */
	public void write(int c) {
		System.out.print(c);
	}
}
