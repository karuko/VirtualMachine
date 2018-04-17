package tp.pr2.mv.VirtualMachine;

// TODO: Auto-generated Javadoc
/**
 * An asynchronous update interface for receiving notifications
 * about Stack information as the Stack is constructed.
 *
 * @param <T> the generic type
 */
public interface StackObserver<T> {

	/**
	 * This method is called when information about an Stack
	 * which was previously requested using an asynchronous
	 * interface becomes available.
	 *
	 * @param value the value
	 */
	public void onPush(T value);
	
	/**
	 * This method is called when information about an Stack
	 * which was previously requested using an asynchronous
	 * interface becomes available.
	 *
	 * @param value the value
	 */
	public void onPop(T value);
	public void onStackReset();
}
