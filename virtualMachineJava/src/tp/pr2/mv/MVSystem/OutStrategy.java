package tp.pr2.mv.MVSystem;

import java.io.IOException;

// TODO: Auto-generated Javadoc
/**
 * The Interface OutStrategy.
 */
public interface OutStrategy {
	
	/**
	 * Open.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void open() throws IOException;
	
	/**
	 * Close.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void close() throws IOException;
	
	/**
	 * Write.
	 *
	 * @param x the x
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void write (int x) throws IOException;
}
