package tp.pr2.mv.VirtualMachine;
import java.util.ArrayList;

import tp.pr2.mv.Exceptions.ExceptionDivisionByZero;
import tp.pr2.mv.Exceptions.ExceptionNegativeDirection;
import tp.pr2.mv.Exceptions.ExceptionOperand;
import tp.pr2.mv.Exceptions.MVError;
import tp.pr2.mv.Exceptions.MemoryStringException;
import tp.pr2.mv.Instructions.Instruction;
import tp.pr2.mv.MVSystem.InStrategy;
import tp.pr2.mv.MVSystem.OutStrategy;
import tp.pr2.mv.RestSeq.Halt;

	// TODO: Auto-generated Javadoc
/**
	 * The Class CPU.
	 */
	public class CPU implements Observable<CPUObserver> {
		
		/** The observers. */
		private ArrayList<CPUObserver> observers;
		
		
		/** Memoria de la mv. */
		private Memory<Integer> memory;
		
		/** Pila de operandos. */
		private OperandStack<Integer> stack;
		
		/** Controla el final de la ejecucion con ”halt”. */
		private boolean exit;
		
		/** Controla que el contador de programa este dentro del programa. */
		
		private boolean correctPC;
		
		/** Contador del programa;. */
		private int pc;
		
		/** Programa a ejecutar. */
		private ProgramMv program;
		
		/** The in stream. */
		private InStrategy inStream;
		
		/** The out stream. */
		private OutStrategy outStream;
		
		/** The Constant NEWLINE. */
		public static final String NEWLINE = System.getProperty("line.separator");
		
	
	//Metodos

	/* (non-Javadoc)
	 * @see tp.pr2.mv.VirtualMachine.Observable#addObserver(java.lang.Object)
	 */
	public void addObserver(CPUObserver o){
		observers.add(o);
	}
	
	/* (non-Javadoc)
	 * @see tp.pr2.mv.VirtualMachine.Observable#removeObserver(java.lang.Object)
	 */
	public void removeObserver(CPUObserver o){
		observers.remove(o);
	}
		
		
		
		/**
	 * Instantiates a new cpu.
	 */
	public CPU()
		{
			this.memory = new Memory<Integer>();
			this.stack = new OperandStack<Integer>();
			this.correctPC = true;
			this.exit = false;
			
			observers = new ArrayList<CPUObserver>();
		}
		
		/**
		 * Load program.
		 *
		 * @param p the p
		 */
		public void loadProgram(ProgramMv p)
		{
			this.program = p;
		}
		
		
		/**
		 * ejecución de la instrucción halt.
		 */
		public void exit()
		{
			new Halt();
			
		}
		
		/**
		 * Gets the program.
		 *
		 * @return the program
		 */
		public ProgramMv getProgram(){
			
			return program;
		}

		/**
		 * inicializa todos los atributos de la CPU para preparar una ejecución con ”run”.
		 */
		public void resetCPU()
		{
			this.memory = new Memory<Integer>();
			this.stack = new OperandStack<Integer>();
			this.correctPC = true;
			this.exit = false;
		}
		

		/**
		 * devuelve la siguiente instrucción a ejecutar, es decir la situada en el contador de programa en caso de que este sea correcto. En otro caso devuelve null
		 *
		 * @return the current instruction
		 */
		public Instruction getCurrentInstruction()
		{
			Instruction ins = null;
			
	        if (pc <= program.getSizeProgram()) 
	          return  ins = program.get(pc);
	        
	        	return ins;
		}
		
		
		/**
		 * devuelve true si la ejecución debe detenerse bien porque el contador de programa es incorrecto  o bien porque se ejecutó la instrucción ”halt”.
		 *
		 * @return true, if successful
		 */
		public boolean abortComputation()
		{

			if(!correctPC) 
				return true;
			
			else
				return false;
		}
		
		/**
		 * ejecuta la siguiente instrucción, es decir la situada en el contador de programa.
		 *
		 * @return true, if successful
		 */
		public void step()
		{
			 
		      Instruction inst = this.getCurrentInstruction();
		      
		      for(CPUObserver o : observers){
					o.onStartInstrExecution(inst);
				}
		      
		      try{
		    	  inst.execute(this); 
		       
		      }catch(ExceptionDivisionByZero e){
		    	  for(CPUObserver o : observers){
						o.onError(e.getMessage());
					}
		    	  throw e;
		      }catch(ExceptionOperand e){
		    	  for(CPUObserver o : observers){
						o.onError( "Error ejecutando "+ this.getCurrentInstruction() + e.getMessage() +" hay" + "(" + this.getSizeStack() + ")" );
					}
		    	  throw e;
		    	  
		      }catch(ExceptionNegativeDirection e){
		    	  for(CPUObserver o : observers){
						o.onError(" Error ejecutando "+ this.getCurrentInstruction() + e.getMessage());
					}
		    	  throw e;
		      }catch(MemoryStringException m){
		    	  
		      }
		      
		      for(CPUObserver o : observers){
					o.onEndInstrExecution(pc, stack, memory);
					o.onHalt();
				}
		      
		      
		}
		
		/**
		 * Step gui.
		 */
		public void stepGUI()
		{
			Instruction inst = this.getCurrentInstruction();
			inst.execute(this);
		}
		
		/**
		 * Stepn.
		 *
		 * @param n the n
		 */
		public void stepn(int n){
			for(int i = 0; i < n; i++)
				this.step();
		}
		
	

	/**
	 * Incrementa el contador de programa.
	 */
	public void increaseProgramCounter() 
	{
		 pc ++;
		 
        if (pc >= program.getSizeProgram()) 
        {
            correctPC = false;
        }
       
	}
	
	/**
	 * Obtiene el tamaño de la pila.
	 *
	 * @return Tamaño de la pila
	 */
	public int getSizeStack() 
	{
		return stack.getSizeStack();
	}

	/**
	 * Push.
	 *
	 * @param v the v
	 */
	public void push(int v) 
	{
		stack.push(v);
	}
	
	
	/**
	 * Pop.
	 *
	 * @return the int
	 */
	public int pop() 
	{
		if(this.getSizeStack() == 0){
			for(CPUObserver o : observers){
				o.onError(" Faltan operandos en la pila ");
			}
			
			throw new ExceptionOperand();
			
		}
		
			int n = 0;
			n = stack.pop();
			return n;
	}
	
	/**
	 * Gets the value.
	 *
	 * @param pos the pos
	 * @return the value	 */
	
	public int getValue(int pos)
	{
		
		return memory.getValue(pos);
		
	}
	
	/**
	 * Sets the value.
	 *
	 * @param pos the pos
	 * @param value the value
	 * @return the int
	 */
	public void setValue(int pos, int value)
	{
		
		
			memory.setValue(pos, value);
		
	}
	
	/**
	 * Jump cpu.
	 *
	 * @param n the n
	 * @return true, if successful
	 */
	public boolean JumpCpu(int n)
	{
		 
	        if (n < program.getSizeProgram()) {
	            this.pc = n;
	           return  true;
	        } 
	        
	        else 
	        {
	            correctPC = false;
	        	return false;
	        }
		
	}

//	public String toString()
//	{
//		String text = NEWLINE + "Estado de la máquina tras ejecutar la instrucción es: "+ NEWLINE ;
//		text = text + this.memory.toString() + NEWLINE + this.stack.toString() + NEWLINE;
//		return text;
//	}

	/**
 * Checks if is finish.
 */
public void isFinish() {
		this.exit = true;
		 

	}
	
	/**
	 * Checks if is finished.
	 *
	 * @return true, if is finished
	 */
	public boolean isFinished(){
		
		return this.exit;
	}
	
	/**
	 * R jump cpu.
	 *
	 * @param n the n
	 */
	public void RJumpCpu(int n){
		this.pc = this.pc + n;
		
	}
	
	/**
	 * Sets the in stream.
	 *
	 * @param s the new in stream
	 */
	public void setInStream(InStrategy s){
		if(s==null) throw new MVError("Cannot set inStream to null");
		else inStream = s;
	}
	
	/**
	 * Sets the out stream.
	 *
	 * @param s the new out stream
	 */
	public void setOutStream(OutStrategy s){
		if(s == null) throw new MVError("Cannot set outStream to null");
		else outStream = s;
	}
	
	/**
	 * Gets the in stream.
	 *
	 * @return the in stream
	 */
	public InStrategy getInStream(){ return inStream;}
	
	/**
	 * Gets the out stream.
	 *
	 * @return the out stream
	 */
	public OutStrategy getOutStream(){ return outStream;}

	
	/**
	 * Run.
	 */
	public void run() {
		
		for(CPUObserver o : observers){
			o.onStartRun();
		}
		
		 while(!this.abortComputation()){
			 this.step();
		 }
		 
		 for(CPUObserver o : observers){
				o.onEndRun();
				
			}
		
	}

	/**
	 * Gets the pc.
	 *
	 * @return the pc
	 */
	public int getPC() {
		
		return pc;
	}

	
	/**
	 * Gets the memory.
	 *
	 * @return the memory
	 */
	public Memory<Integer> getMemory() {
		return memory;
	}
	
	/**
	 * Gets the operand stack.
	 *
	 * @return the operand stack
	 */
	public OperandStack<Integer> getOperandStack(){
		return stack;
	}
	
	public void reset(){
		
		pc = 0;
		memory.reset();
		memory = new Memory<Integer>();
		stack.reset();
		stack = new OperandStack<Integer>();
		correctPC = true;
		exit = false;
		
		observers = new ArrayList<CPUObserver>();
		
		for(CPUObserver o : observers){
			o.onReset(program);
		}
	}

	
		
}
