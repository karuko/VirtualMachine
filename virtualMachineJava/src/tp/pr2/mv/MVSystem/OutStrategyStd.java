package tp.pr2.mv.MVSystem;

import java.io.IOException;

// TODO: Auto-generated Javadoc
/**
 * The Class OutStrategyStd.
 */
public class OutStrategyStd implements OutStrategy {

	/* (non-Javadoc)
	 * @see tp.pr2.mv.MVSystem.OutStrategy#open()
	 */
	@Override
	public void open() throws IOException {

	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.MVSystem.OutStrategy#close()
	 */
	@Override
	public void close() throws IOException {

	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.MVSystem.OutStrategy#write(int)
	 */
	@Override
	public void write(int c) {
		System.out.print((char)c);
	}

}
