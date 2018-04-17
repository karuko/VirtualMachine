package tp.pr2.mv.VirtualMachine;

import java.util.ArrayList;
import java.util.TreeMap;
import tp.pr2.mv.Exceptions.ExceptionMemory;



// TODO: Auto-generated Javadoc
/**
 * The Class Memory.
 *
 * @param <T> the generic type
 */
public class Memory<T> implements Observable<MemoryObserver<T>>
{
	
	
	/** The observers. */
	private ArrayList<MemoryObserver<T>> observers;
	/** array de memoria. */
    private TreeMap <Integer, T> memory;  
     /** 
      * capacidad inicial. 
      */
      
        public Memory() 
        { 
         
           observers = new ArrayList<MemoryObserver<T>>();
           this.memory = new TreeMap <Integer, T>();                    
        } 
          
        /** 
         * Devuelve el valor que esta en memoria en la posicion pasada. Si la posición buscada es menor que la capacidad, existirá en el array 
         * 
         * @param pos Posición de la memoria 
         * @return El numero que contenga la posición 
         *  0 si la posición buscada es mayor que la capacidad 
         */
        public T getValue(int pos)  
        { 
        	if(this.memory.get(pos) == null) throw new ExceptionMemory(pos);
        	else return this.memory.get(pos);  
  
        } 
          
        /** 
         * Cambia el valor de la posicion en el array memoria que se le diga.  
         * Si la posicion donde se quiere introducir el nuevo valor es menor que la capacidad se pone el valor en esa posición 
         * Si es mayor se redimensiona el array y se mete el valor en esa posición. 
         * @param pos : La posición de la memoria. 
         * @param value : Valor de la posición. 
         * @return Un valor. 
         */
        public void setValue(int pos, T value)  
        { 
        	
            this.memory.put(pos, value);
            for(MemoryObserver<T> o : observers)
	    		o.onWrite(pos, value);
        } 
        public void reset(){
        	memory.clear();
        	for(MemoryObserver<T> o : observers)
	    		o.onMemReset();
        }
          
          
        /* (non-Javadoc)
         * @see java.lang.Object#toString()
         */
        public String toString()
        { /*escritura por pantalla de la memoria*/
            boolean not_empty = false; /*para que si esta vacia no salga nada*/
            String text = "EL CONTENIDO DE LA MEMORIA ES:"; 
            for(int i = 0; i < this.memory.size();i++) 
            { 
                if(memory.get(i) != null) /* recorre toda la memoria*/
                { 
                    text = text + " [" + i + "] " + memory.get(i); 
                    not_empty = true; /*encuantro encuentra uno no vacio avisa para que no salga la palabra VACIO*/
                }                                
            } 
            if(not_empty == false ) text = text + "<VACIO>"; /*si esta vacio*/
              
            return text; 
        } 
	
        /**
         * The Class MemCell.
         *
         * @param <T> the generic type
         */
        public static class MemCell<T>{
    		
		    /** The pos. */
		    int pos;
    		
		    /** The value. */
		    Integer value;
    		
    		/**
		     * Instantiates a new mem cell.
		     *
		     * @param pos the pos
		     * @param value the value
		     */
		    public MemCell(int pos, Integer value){
    			this.pos = pos;
    			this.value = value;
    		}
    		

			/**
			 * Gets the pos.
			 *
			 * @return the pos
			 */
			public int getPos(){
    			return pos;
    		}
    		
		    /**
		     * Gets the value.
		     *
		     * @return the value
		     */
		    public Integer getValue(){
    			return value;
    		}
    }
    
    /**
     * Gets the array.
     *
     * @return the array
     */
    public TreeMap<Integer, T> getArray() {
    	
    	return memory;
    	
    }

	/* (non-Javadoc)
	 * @see tp.pr2.mv.VirtualMachine.Observable#addObserver(java.lang.Object)
	 */
	@Override
	public void addObserver(MemoryObserver<T> o) {
		observers.add(o);
		
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.VirtualMachine.Observable#removeObserver(java.lang.Object)
	 */
	@Override
	public void removeObserver(MemoryObserver<T> o) {
		observers.remove(o);
		
	}
        
        
}
