package tp.pr2.mv.Controlers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import tp.pr2.mv.CommandInstruction.CommandInt;
import tp.pr2.mv.CommandInstruction.CommandParser;
import tp.pr2.mv.Exceptions.ExceptionDivisionByZero;
import tp.pr2.mv.Exceptions.ExceptionOperand;
import tp.pr2.mv.VirtualMachine.CPU;

// TODO: Auto-generated Javadoc
/**
 * The Class InteractiveControler.
 */
public class InteractiveControler extends Controler {

	/**
	 * Instantiates a new interactive controler.
	 *
	 * @param cpu the cpu
	 */
	public InteractiveControler(CPU cpu) {
		super(cpu);
		
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.Controlers.Controler#start()
	 */
	@Override
	public void start() {
		 CommandInt instrCommand;
			InputStreamReader isr = new InputStreamReader(System.in);
	        BufferedReader br = new BufferedReader(isr);
		String line;
	
			while (!cpu.isFinished() && !cpu.abortComputation())
				{	
					
				  try{
					 line = br.readLine();
					 instrCommand = CommandParser.parseCommand(line);
			            
			            if (instrCommand != null)
			                 instrCommand.executeCommand();        
			        
							
					} catch (IOException e) {
						
						e.printStackTrace();
					}catch(ExceptionDivisionByZero d){
						
					}catch(ExceptionOperand o){
							
							
					}
			            
			            
		//CommandInterpreter instrCommand = ParseCommand.readCommandInstruction(commandInst);
		// ejecuta la instrucción (instrCommand.executeCommand())
		// controlando posibles errores y/o fin de la ejecucion.
		// Si el procesamiento es correcto entonces leer la siguiente
		// instruccion (commandInst)
				}
		
	}

}
