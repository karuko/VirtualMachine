package tp.pr2.mv.VirtualMachine;




import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import tp.pr2.mv.CommandInstruction.CommandInt;
import tp.pr2.mv.Controlers.BatchControler;
import tp.pr2.mv.Controlers.InteractiveControler;
import tp.pr2.mv.Controlers.SwingControler;
import tp.pr2.mv.Exceptions.CmdLineException;
import tp.pr2.mv.Exceptions.MVError;
import tp.pr2.mv.MVSystem.*;
import tp.pr2.mv.Views.BatchView;
import tp.pr2.mv.Views.InteractiveView;
import tp.pr2.mv.gui.swing.MainWindow;


// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main 
{
	
	/** The program. */
	private static ProgramMv program;
	
	/** The cpu. */
	private static CPU cpu;
	
	/** The Constant _BATCH_MODE. */
	private static final int _BATCH_MODE = 0;
	
	/** The Constant _INTER_MODE. */
	private static final int _INTER_MODE = 1;
	
	/** The Constant _WINDOW_MODE. */
	private static final int _WINDOW_MODE = 2;
	
	/** The Constant _NULL_STREAM. */
	private static final int _NULL_STREAM = 3;
	
	/** The Constant _STD_STREAM. */
	private static final int _STD_STREAM = 4;
	
	/** The Constant _FILE_STREAM. */
	private static final int _FILE_STREAM = 5;
	
	
	/** The execution mode. */
	private static int executionMode = _INTER_MODE;
	
	/** The in stream mode. */
	private static int inStreamMode = _NULL_STREAM;
	
	/** The out stream mode. */
	private static int outStreamMode = _NULL_STREAM;
	
	/** The in stream file name. */
	private static String inStreamFileName;
	
	/** The out stream file name. */
	private static String outStreamFileName;
	
	/** The program file name. */
	private static String programFileName;
	
	/** The op. */
	static Options op = new Options();
	
	/** The sc. */
	Scanner sc = new Scanner(System.in);  
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException{
		try{
		startMV(args);
		}catch(CmdLineException c){
			System.err.println(c.getMessage());
			System.exit(1);
		}catch(FileNotFoundException f){
			System.err.println( f + " Use -h|--help para más detalles.");
			System.exit(1);
		}
	}
	
	/**
	 * Start mv.
	 *
	 * @param args the args
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void startMV(String[] args) throws IOException{
		cpu = new CPU();
	
		
		try{
			parseOptions(args);
			switch(executionMode){
			case _INTER_MODE:
				interactiveMode(); break;
			case _BATCH_MODE:
				batchMode(); break;
			case _WINDOW_MODE:
				windowMode(); break;
				
			}
		}catch(Exception c){

			System.err.println(c.getMessage());
			System.exit(1);
		}
				
	}

	/**
	 * Window mode.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private static void windowMode() throws IOException {
		InStrategy input = null;
		OutStrategy output = null;
		
		if(outStreamMode == _FILE_STREAM && inStreamMode == _FILE_STREAM ){
			 input = new InStrategyFile(inStreamFileName); 
			 output = new OutStrategyFile(outStreamFileName); 
		}
		
		else if (inStreamMode == _FILE_STREAM && outStreamMode == _STD_STREAM){
			input = new InStrategyFile(inStreamFileName);
			output = new OutStrategyStd();
		}
		
		
		else{
			input = new InStrategyNada();
			output = new OutStrategyStd();
		}
			input.open();
			output.open();
		
		cpu.setInStream(input);
		cpu.setOutStream(output);
		
		 program = ProgramMv.readProgramFile(programFileName);
		 cpu.loadProgram(program);
		 
		SwingControler ctrl = new SwingControler(cpu);
		MainWindow view = new MainWindow(ctrl, cpu, cpu.getOperandStack(), cpu.getMemory() );
		ctrl.start();
		view.setVisible(true);
		
		
	}

	/**
	 * Batch mode.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private static void batchMode() throws IOException {
		InStrategy input = null;
		OutStrategy output = null;
		
		if(outStreamMode == _FILE_STREAM && inStreamMode == _FILE_STREAM ){
			 input = new InStrategyFile(inStreamFileName); 
			 output = new OutStrategyFile(outStreamFileName); 
		}
		else if (inStreamMode == _FILE_STREAM && outStreamMode == _STD_STREAM){
			input = new InStrategyFile(inStreamFileName);
			output = new OutStrategyStd();
		}
			input.open();
			output.open();
		
		cpu.setInStream(input);
		cpu.setOutStream(output);

		
		
		 program = ProgramMv.readProgramFile(programFileName);
		 cpu.loadProgram(program);
		 CommandInt.configureCommandInt(cpu);
		 
//			try{
//			cpu.run();
//			}catch(ExceptionOperand o){
//				System.err.println("Error ejecutando "+ cpu.getCurrentInstruction() + o.getMessage() +" hay" + "(" + cpu.getSizeStack() + ")");
//				cpu.getInStream().close();
//				cpu.getOutStream().close();
//				System.exit(2);
//			}catch(ExceptionNegativeDirection n){
//				System.err.println("Error ejecutando "+ cpu.getCurrentInstruction() + n.getMessage());
//				cpu.getInStream().close();
//				cpu.getOutStream().close();
//				System.exit(2);
//			}catch(ExceptionDivisionByZero d){
//				System.err.println(d.getMessage());
//				cpu.getInStream().close();
//				cpu.getOutStream().close();
//				System.exit(2);
//			}
			
		BatchControler ctrl = new BatchControler(cpu);
		BatchView view = new BatchView(cpu);
		
		
		ctrl.start();
		
		
		cpu.getInStream().close();
		cpu.getOutStream().close();
	}

	/**
	 * Interactive mode.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private static void interactiveMode() throws IOException {
		
		InStrategy input = null;
		OutStrategy output = null;
		
		
		if(outStreamMode == _FILE_STREAM && inStreamMode == _FILE_STREAM ){
			 input = new InStrategyFile(inStreamFileName); 
			 output = new OutStrategyFile(outStreamFileName); 
		}
		else if (inStreamMode == _FILE_STREAM && outStreamMode == _STD_STREAM){
			input = new InStrategyFile(inStreamFileName);
			output = new OutStrategyStd();
		}
		else
		{
			input = new InStrategyNada();
			output = new OutStrategyStd();
		}
			input.open();
			output.open();
				
			cpu.setInStream(input);
			cpu.setOutStream(output);
			
		
		if(programFileName != null)
			program = ProgramMv.readProgramFile(programFileName);
		
		else 
			program = ProgramMv.readProgram();
		
		cpu.loadProgram(program);
		CommandInt.configureCommandInt(cpu);
		
		InteractiveControler ctrl = new InteractiveControler(cpu);
		InteractiveView view = new InteractiveView(cpu);
		ctrl.start();
		
		
		cpu.getInStream().close();
		cpu.getOutStream().close();
	}
	
	
	
	/**
	 * Parses the options.
	 *
	 * @param args the args
	 */
	private static void parseOptions(String[] args) {
		
		op.parse(args);
		inStreamFileName = op.getI();
		outStreamFileName = op.getO();
		programFileName = op.getA();
		
		if(op.getH() != null){
			
			System.out.println(" usage: tp.pr3.mv.Main [-a <asmfile>] [-h] [-i <infile>] [-m <mode>] [-o <outfile>]");
			System.out.println(" -a,--asm <asmfile> Fichero con el codigo en ASM del programa a ejecutar. Obligatorio en modo batch.");
			System.out.println(" -h,--help Muestra esta ayuda");
			System.out.println(" -i,--in <infile> Entrada del programa de la maquina-p");
			System.out.println(" -m,--mode <mode> Modo de funcionamiento (batch | interactive). Por defecto, batch.");
			System.out.println(" -o,--out <outfile> Fichero donde se guarda la salida del programa de la maquina-p.");	
			System.exit(0);
		}
		
		if(op.getM().equalsIgnoreCase("interactive")){
			executionMode = 1;
			if(inStreamFileName != null)inStreamMode = 5;
			if(outStreamFileName != null) outStreamMode = 5;
			else 
				outStreamMode = 4;
			
		}
		if(op.getM().equalsIgnoreCase("batch")){
			executionMode = 0; 
			if(inStreamFileName != null) inStreamMode = 5;
			if(outStreamFileName != null) outStreamMode = 5;
			else
				outStreamMode = 4;
		}
		if(op.getM().equalsIgnoreCase("window")){
			executionMode = 2;
			if(inStreamFileName != null) inStreamMode = 5;
			if(outStreamFileName != null) outStreamMode = 5;
			else 
				outStreamMode = 4;
		}
		
		if(executionMode != 1 && programFileName == null){
			throw new MVError("No existe fichero de programa");
		}
			
	}
	
}







