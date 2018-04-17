package tp.pr2.mv.gui.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import tp.pr2.mv.Controlers.Controler;
import tp.pr2.mv.Instructions.Instruction;
import tp.pr2.mv.VirtualMachine.CPUObserver;
import tp.pr2.mv.VirtualMachine.Memory;
import tp.pr2.mv.VirtualMachine.Observable;
import tp.pr2.mv.VirtualMachine.OperandStack;
import tp.pr2.mv.VirtualMachine.ProgramMv;

// TODO: Auto-generated Javadoc
/**
 * The Class ToolBarPanel.
 */
@SuppressWarnings("serial")
public class ToolBarPanel extends JPanel implements CPUObserver{
	
	/** The ctrl. */
	private Controler ctrl;
	
	/** The step button. */
	private JButton stepButton;
	
	/** The run button. */
	private JButton runButton;
	
	/** The exit button. */
	private JButton exitButton;
	private JButton resetButton;
	
	
	/**
	 * Instantiates a new tool bar panel.
	 *
	 * @param ctrl the ctrl
	 * @param cpu the cpu
	 */
	ToolBarPanel(Controler ctrl, Observable<CPUObserver> cpu) {
		this.ctrl = ctrl;
		initGUI();
		cpu.addObserver(this);
	}

	/**
	 * Inits the gui.
	 */
	private void initGUI(){
		 stepButton = new JButton();
		stepButton.setIcon(createImageIcon("step.png"));
		stepButton.setToolTipText("Step");
		this.add(stepButton);
		stepButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ctrl.step();
			}
		});
		
		 runButton = new JButton();
		runButton.setIcon(createImageIcon("run.png"));
		runButton.setToolTipText("Run");
		this.add(runButton);
		runButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ctrl.run();
			}
		});
		
		 exitButton = new JButton();
		exitButton.setIcon(createImageIcon("exit.png"));
		exitButton.setToolTipText("Exit");
		this.add(exitButton);
		exitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
					
					int n = JOptionPane.showOptionDialog(new JFrame(),"Are sure you want to quit?", "Quit",
							 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
									null, null);
				if(n == 0)	
					ctrl.quit();
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		  resetButton = new JButton();
		  resetButton.setIcon(createImageIcon("exit.png"));
		  resetButton.setToolTipText("Reset");
			this.add(resetButton);
			resetButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					ctrl.reset();
				}
			});
		
				
	}
	
	/**
	 * Creates the image icon.
	 *
	 * @param path the path
	 * @return the image icon
	 */
	private static ImageIcon createImageIcon(String path){
		java.net.URL imgURL = MainWindow.class.getResource(path);
		if(imgURL != null) return new ImageIcon(imgURL);
		return null;
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
		runButton.setEnabled(false);
		stepButton.setEnabled(false);
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.VirtualMachine.CPUObserver#onEndRun()
	 */
	@Override
	public void onEndRun() {
		runButton.setEnabled(true);
		stepButton.setEnabled(true);
		
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.VirtualMachine.CPUObserver#onError(java.lang.String)
	 */
	@Override
	public void onError(String msg) {
		
		
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
		runButton.setEnabled(true);
		stepButton.setEnabled(true);
		
	}
}
