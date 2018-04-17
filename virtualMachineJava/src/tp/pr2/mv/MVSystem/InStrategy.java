package tp.pr2.mv.MVSystem;

import java.io.FileNotFoundException;
import java.io.IOException;

// TODO: Auto-generated Javadoc
/**
 * The Interface InStrategy.
 */
public interface InStrategy {
	
	/**
	 * Open.
	 *
	 * @throws FileNotFoundException the file not found exception
	 */
	public void open() throws FileNotFoundException;
	
	/**
	 * Close.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void close() throws IOException;
	
	/**
	 * Read.
	 *
	 * @return the int
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public int read() throws IOException;
}
