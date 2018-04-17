package tp.pr2.mv.VirtualMachine;

// TODO: Auto-generated Javadoc
/**
 * The Interface Observable.
 *
 * @param <T> the generic type
 */
public interface Observable<T> {
	
	/**
	 * Adds the observer.
	 *
	 * @param o the o
	 */
	public void addObserver( T o);
	
	/**
	 * Removes the observer.
	 *
	 * @param o the o
	 */
	public void removeObserver(T o);
}
