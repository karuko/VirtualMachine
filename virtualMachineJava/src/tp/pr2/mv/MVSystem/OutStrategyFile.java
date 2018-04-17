package tp.pr2.mv.MVSystem;

import java.io.FileWriter;
import java.io.IOException;


// TODO: Auto-generated Javadoc
/**
 * The Class OutStrategyFile.
 */
public class OutStrategyFile implements OutStrategy {
	 
 	/** The fname. */
 	String fname;
	 
 	/** The f. */
 	FileWriter f;
	 

	/**
	 * Instantiates a new out strategy file.
	 *
	 * @param fname the fname
	 */
	public OutStrategyFile(String fname){
		this.fname = fname;
	}
	
	/* (non-Javadoc)
	 * @see tp.pr2.mv.MVSystem.OutStrategy#open()
	 */
	@Override
	public void open() throws IOException {
		f = new FileWriter(fname);
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.MVSystem.OutStrategy#close()
	 */
	@Override
	public void close() throws IOException {
		f.close();
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.MVSystem.OutStrategy#write(int)
	 */
	@Override
	public void write(int x) throws IOException {
			f.write((char)x);
		
		}
}


