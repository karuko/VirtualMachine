package tp.pr2.mv.VirtualMachine;

// TODO: Auto-generated Javadoc
/**
 * An asynchronous update interface for receiving notifications
 * about Memory information as the Memory is constructed.
 *
 * @param <T> the generic type
 */
public interface MemoryObserver<T> {

	/**
	 * This method is called when information about an Memory
	 * which was previously requested using an asynchronous
	 * interface becomes available.
	 *
	 * @param index the index
	 * @param value the value
	 */
	public void onWrite(int index, T value);
	public void onMemReset();	
}
