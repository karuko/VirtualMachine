package tp.pr2.mv.VirtualMachine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;



// TODO: Auto-generated Javadoc
/**
 *  
 * La Clase OperandStack.
 *
 * @param <T> the generic type
 */

public class OperandStack<T> implements Observable<StackObserver<T>>
{
		
		/** The observers. */
		private ArrayList<StackObserver<T>> observers;
	
	    /** The l. */
    	LinkedList<T> l = new LinkedList<T>();
	    
	    /**
    	 * Instantiates a new operand stack.
    	 */
    	public OperandStack() 
	    { 
	    	observers = new ArrayList<StackObserver<T>>();
	    } 
	      
	    /**
    	 *  
    	 * Coge el tamaño de la pila .
    	 *
    	 * @return cima que es el tamaño actual de la pila
    	 */
	    public int getSizeStack() 
	    {  
	        return l.size(); 
	    } 
	     
	    /** 
	     * Pop. 
	     * 
	     * @return el ultimo numero de la pila y reduce en uno el tamaño 
	     */
	    public T pop() 
	    {   
	    	
	    	 T n = l.pop();
	    	for(StackObserver<T> o : observers)
	    		o.onPop(n);
	    	return n;
	    	
	    } 
	     
	    /** 
	     * Push: introduce un numero en la pila 
	     * si el tamaño es menor que la capacidad se introduce y se aumenta el tamaño, 
	     * si ya esta en el tamaño maximo, se redimensiona 
	     * y se introduce en la pila. 
	     * @param n es el numero a introducir 
	     */
	    public void push(T n) 
	    {  
	            l.push(n);   
	            for(StackObserver<T> o : observers)
		    		o.onPush(n);
	    } 
	  

	     public void reset(){
	    	 
	    	 l.clear();
	    	 for(StackObserver<T> o : observers)
		    		o.onStackReset();
	     }
	    public String toString()
	    {  
	    	String text = "EL CONTENIDO DE LA PILA ES:"; 
	    	Iterator<T> it = l.iterator();
	    	while(it.hasNext()){
	    		
	    		text = text + " " + it.next() + " ";
	    	}
	    		          
	        return text; 
	    }
	    
    	/**
    	 * Gets the stack.
    	 *
    	 * @param i the i
    	 * @return the t
    	 */
    	public T GetStack(int i){
	    	return l.get(i);
	    }

		/* (non-Javadoc)
		 * @see tp.pr2.mv.VirtualMachine.Observable#addObserver(java.lang.Object)
		 */
		@Override
		public void addObserver(StackObserver<T> o) {
			observers.add(o);
			
		}

		/* (non-Javadoc)
		 * @see tp.pr2.mv.VirtualMachine.Observable#removeObserver(java.lang.Object)
		 */
		@Override
		public void removeObserver(StackObserver<T> o) {
			observers.remove(o);
			
		}
		
	    
	   
} 
	

