package tp.pr2.mv.gui.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.text.BadLocationException;

import tp.pr2.mv.Controlers.Controler;
import tp.pr2.mv.Instructions.Instruction;
import tp.pr2.mv.VirtualMachine.CPUObserver;
import tp.pr2.mv.VirtualMachine.Memory;
import tp.pr2.mv.VirtualMachine.Observable;
import tp.pr2.mv.VirtualMachine.OperandStack;
import tp.pr2.mv.VirtualMachine.ProgramMv;


// TODO: Auto-generated Javadoc
/**
 * The Class ProgramPanel.
 */
@SuppressWarnings("serial")
public class ProgramPanel extends JPanel implements CPUObserver {

	/** The ctrl. */
	private Controler ctrl;
	
	/** The program text area. */
	private JTextArea programTextArea;
	
	/** The program. */
	private ProgramMv program;
	
	/** The pc. */
	private int pc;
	
	 /**
 	 * Instantiates a new program panel.
 	 *
 	 * @param ctrl the ctrl
 	 * @param cpu the cpu
 	 */
 	ProgramPanel(Controler ctrl, Observable<CPUObserver> cpu) {
		 this.ctrl = ctrl;
			initGUI();
			cpu.addObserver(this);
	}

	/**
	 * Inits the gui.
	 */
	private void initGUI(){
		this.setLayout(new BorderLayout());
		this.setBorder(new TitledBorder("Program"));
		this.setMinimumSize(new Dimension(300,300));
		
		programTextArea = new JTextArea(20, 15);
		programTextArea.setFont(new Font("Courier", Font.PLAIN, 16));
		programTextArea.setEditable(false);

		this.add(new JScrollPane(programTextArea));
		
		program = ctrl.getProgram();
		pc = 0;
		showProgram();
	
	}
	
	/**
	 * Show program.
	 */
	private void showProgram() {
		
		programTextArea.setText("");
		programTextArea.append(ctrl.getProgram().toString());
		try {
			programTextArea.insert("* ", programTextArea.getLineStartOffset(this.pc));
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		
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
		this.pc = pc;
		showProgram();
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
		
		
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.VirtualMachine.CPUObserver#onError(java.lang.String)
	 */
	@Override
	public void onError(String msg) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.VirtualMachine.CPUObserver#onHalt()
	 */
	@Override
	public void onHalt() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.VirtualMachine.CPUObserver#onReset(tp.pr2.mv.VirtualMachine.ProgramMv)
	 */
	@Override
	public void onReset(ProgramMv program) {
		this.pc = 0;
		showProgram();
		
	}
}
