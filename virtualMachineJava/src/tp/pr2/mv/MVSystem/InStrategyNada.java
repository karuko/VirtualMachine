package tp.pr2.mv.MVSystem;

import java.io.FileNotFoundException;
import java.io.IOException;

// TODO: Auto-generated Javadoc
/**
 * The Class InStrategyNada.
 */
public class InStrategyNada implements InStrategy {

	/* (non-Javadoc)
	 * @see tp.pr2.mv.MVSystem.InStrategy#open()
	 */
	@Override
	public void open() throws FileNotFoundException {

	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.MVSystem.InStrategy#close()
	 */
	@Override
	public void close() throws IOException {
	
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.MVSystem.InStrategy#read()
	 */
	@Override
	public int read() throws IOException {
		return -1;
	}

}
