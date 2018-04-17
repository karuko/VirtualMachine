package tp.pr2.mv.MVSystem;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// TODO: Auto-generated Javadoc
/**
 * The Class InStrategyFile.
 */
public class InStrategyFile implements InStrategy {

	/** The fname. */
	String fname;
	
	/** The f. */
	FileReader f;
	
	/**
	 * Instantiates a new in strategy file.
	 *
	 * @param fname the fname
	 */
	public InStrategyFile(String fname){
		this.fname = fname;
	}
	
	
	/* (non-Javadoc)
	 * @see tp.pr2.mv.MVSystem.InStrategy#open()
	 */
	public void open() throws FileNotFoundException {
		f = new FileReader(fname);

	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.MVSystem.InStrategy#close()
	 */
	@Override
	public void close() throws IOException {
		f.close();
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.MVSystem.InStrategy#read()
	 */
	@Override
	public int read() throws IOException {
		if (f.ready()) return f.read();
		return -1;
	}

}
