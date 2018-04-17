package tp.pr2.mv.gui.swing;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import tp.pr2.mv.Controlers.Controler;
import tp.pr2.mv.Instructions.Instruction;
import tp.pr2.mv.VirtualMachine.CPUObserver;
import tp.pr2.mv.VirtualMachine.Memory;
import tp.pr2.mv.VirtualMachine.MemoryObserver;
import tp.pr2.mv.VirtualMachine.Observable;
import tp.pr2.mv.VirtualMachine.OperandStack;
import tp.pr2.mv.VirtualMachine.ProgramMv;
import tp.pr2.mv.VirtualMachine.StackObserver;


// TODO: Auto-generated Javadoc
/**
 * The Class MainWindow.
 */
@SuppressWarnings("serial")
public class MainWindow extends JFrame implements CPUObserver {
	
	/** The tool bar. */
	private ToolBarPanel toolBar;
	
	/** The program view. */
	private ProgramPanel programView;
	
	/** The stack view. */
	private StackPanel stackView;
	
	/** The memory view. */
	private MemoryPanel memoryView;
	
	/** The input view. */
	private InputPanel inputView;
	
	/** The output view. */
	private OutputPanel outputView;
	
	/** The status view. */
	private StatusBarPanel statusView;
	
	/** The ctrl. */
	private Controler ctrl;
	
	/** The cpu. */
	private Observable<CPUObserver> cpu ;
	
	/** The stack. */
	private Observable<StackObserver<Integer>> stack ;
	
	/** The memory. */
	private Observable<MemoryObserver<Integer>> memory;
	
	
	/**
	 * Instantiates a new main window.
	 *
	 * @param ctrl the ctrl
	 * @param cpu the cpu
	 * @param stack the stack
	 * @param memory the memory
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public MainWindow(Controler ctrl, Observable<CPUObserver> cpu, Observable<StackObserver<Integer>> stack, 
			Observable<MemoryObserver<Integer>> memory) throws IOException{
		super("Virtual Machine");
		this.cpu = cpu;
		this.stack = stack;
		this.memory = memory;
		this.ctrl = ctrl;
		initGUI();
		//updateWindow();
		cpu.addObserver(this);
		
	}
	
	
	/**
	 * Report error.
	 *
	 * @param msg the msg
	 * @param title the title
	 */
	private void reportError(String msg, String title){
		JOptionPane.showMessageDialog(new JFrame(), msg, title,
				JOptionPane.ERROR_MESSAGE);
	}; 
	private void resetInfo(String msg, String title){
		JOptionPane.showMessageDialog(new JFrame(), msg, title,
				JOptionPane.DEFAULT_OPTION);
	}; 
	
	/**
	 * Inits the gui.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void initGUI() throws IOException{
		
		//guiCtrl = new GUIControler(cpu, this);
		toolBar = new ToolBarPanel(ctrl, cpu);
		programView = new ProgramPanel(ctrl, cpu);
		stackView = new StackPanel(ctrl, stack, cpu);
		memoryView = new MemoryPanel(ctrl, memory, cpu);
		inputView = new InputPanel(ctrl);
		outputView = new OutputPanel(ctrl);
		statusView = new StatusBarPanel(cpu, stack, memory);
		
		
		JPanel mainPanel = new JPanel(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		
		c.gridx = 0; c.gridy = 0;
		c.gridwidth = 3; c.gridheight = 1;
		c.weightx = 0; c.weighty = 0;
		mainPanel.add( toolBar, c);
		
		c.gridx = 0; c.gridy = 1;
		c.gridwidth = 1; c.gridheight = 3;
		c.weightx = 0; c.weighty = 0;
		mainPanel.add( programView, c);
		
		c.gridx = 1; c.gridy = 1;
		c.gridwidth = 1; c.gridheight = 1;
		c.weightx = 0.5; c.weighty = 0.5;
		mainPanel.add( stackView, c);
		
		c.gridx = 2; c.gridy = 1;
		c.gridwidth = 1; c.gridheight = 1;
		c.weightx = 0.5; c.weighty = 0.5;
		mainPanel.add( memoryView, c);
		
		c.gridx = 1; c.gridy = 2;
		c.gridwidth = 2; c.gridheight = 1;
		c.weightx = 0.1; c.weighty = 0.1;
		mainPanel.add( inputView, c);
		
		c.gridx = 1; c.gridy = 3;
		c.gridwidth = 2; c.gridheight = 1;
		c.weightx = 0.1; c.weighty = 0.1;
		mainPanel.add( outputView, c);
		
		c.gridx = 0; c.gridy = 4;
		c.gridwidth = 3; c.gridheight = 1;
		c.weightx = 0.0; c.weighty = 0.0;
		mainPanel.add( statusView, c);

		
		this.setContentPane(mainPanel);
		
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				
					try {
						ctrl.quit();
					} catch (IOException e1) {
						System.err.println("Error al cerrar la estrategia de entrada o salida");
						e1.printStackTrace();
					
					}
			}

			@Override
			public void windowDeactivated(WindowEvent e) {}
			@Override
			public void windowDeiconified(WindowEvent e) {}
			@Override
			public void windowIconified(WindowEvent e) {}
			@Override
			public void windowOpened(WindowEvent e) {}
			@Override
			public void windowClosed(WindowEvent arg0) {}
			@Override
			public void windowActivated(WindowEvent arg0) {}
		});
		
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	
		
		
	}
	
	
	/* (non-Javadoc)
	 * @see tp.pr2.mv.VirtualMachine.CPUObserver#onStartInstrExecution(tp.pr2.mv.Instructions.Instruction)
	 */
	@Override
	public void onStartInstrExecution(Instruction instr) {
		// TODO Auto-generated method stub
		
	}
	
	/* (non-Javadoc)
	 * @see tp.pr2.mv.VirtualMachine.CPUObserver#onEndInstrExecution(int, tp.pr2.mv.VirtualMachine.OperandStack, tp.pr2.mv.VirtualMachine.Memory)
	 */
	@Override
	public void onEndInstrExecution(int pc, OperandStack<Integer> stack, Memory<Integer> memory) {
		// TODO Auto-generated method stub
		
	}
	
	/* (non-Javadoc)
	 * @see tp.pr2.mv.VirtualMachine.CPUObserver#onStartRun()
	 */
	@Override
	public void onStartRun() {
		// TODO Auto-generated method stub
		
	}
	
	/* (non-Javadoc)
	 * @see tp.pr2.mv.VirtualMachine.CPUObserver#onEndRun()
	 */
	@Override
	public void onEndRun() {
		// TODO Auto-generated method stub
		
	}
	
	/* (non-Javadoc)
	 * @see tp.pr2.mv.VirtualMachine.CPUObserver#onError(java.lang.String)
	 */
	@Override
	public void onError(String msg) {
		this.reportError(msg, "Error");
		
	}
	
	/* (non-Javadoc)
	 * @see tp.pr2.mv.VirtualMachine.CPUObserver#onHalt()
	 */
	@Override
	public void onHalt() {
		
	
	}
	
	/* (non-Javadoc)
	 * @see tp.pr2.mv.VirtualMachine.CPUObserver#onReset(tp.pr2.mv.VirtualMachine.ProgramMv)
	 */
	@Override
	public void onReset(ProgramMv program) {
		this.resetInfo("La máquina se ha reseteado", "Reset");
		
	}
}
