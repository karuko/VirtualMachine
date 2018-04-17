package tp.pr2.mv.gui.swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import tp.pr2.mv.Controlers.Controler;
import tp.pr2.mv.Instructions.Instruction;
import tp.pr2.mv.VirtualMachine.CPUObserver;
import tp.pr2.mv.VirtualMachine.Memory;
import tp.pr2.mv.VirtualMachine.Observable;
import tp.pr2.mv.VirtualMachine.OperandStack;
import tp.pr2.mv.VirtualMachine.ProgramMv;
import tp.pr2.mv.VirtualMachine.StackObserver;

// TODO: Auto-generated Javadoc
/**
 * The Class StackPanel.
 */
@SuppressWarnings("serial")
public class StackPanel extends JPanel implements StackObserver<Integer>, CPUObserver{
	
	/** The ctrl. */
	private Controler ctrl;
	
	/** The stack area. */
	private JList<Integer> stackArea;
	
	/** The model. */
	private DefaultListModel<Integer> model;
	
	/** The stack elem. */
	private JTextField stackElem;
	
	/** The Push button. */
	private JButton PopButton, PushButton;

	
	
	/**
	 * Instantiates a new stack panel.
	 *
	 * @param ctrl the ctrl
	 * @param stack the stack
	 * @param cpu the cpu
	 */
	StackPanel(Controler ctrl, Observable<StackObserver<Integer>> stack,
			Observable<CPUObserver> cpu) {
		this.ctrl = ctrl;
		initGUI();
		stack.addObserver(this);
		cpu.addObserver(this);
	}

	/**
	 * Inits the gui.
	 */
	private void initGUI(){
		this.setLayout(new BorderLayout());
		this.setBorder(new TitledBorder("Operand Stack"));
		
		model = new DefaultListModel<Integer>();
		stackArea = new JList<Integer>(model);
		
		
		JPanel buttonsPanel = new JPanel();
		this.add(buttonsPanel, BorderLayout.PAGE_END);

		
		this.add(new JScrollPane(stackArea));
		
		stackElem = new JTextField(5);
		
		
		 PushButton = new JButton("Push");
		buttonsPanel.add(PushButton);
		PushButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.push(stackElem.getText());
			}
		});
		
		 PopButton = new JButton("Pop");
		buttonsPanel.add(PopButton);
		PopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.pop();
			}
		});
		
		JLabel valName = new JLabel("Value:");
		
		buttonsPanel.add(valName);
		buttonsPanel.add(stackElem);
		buttonsPanel.add(PushButton);
		buttonsPanel.add(PopButton);
		
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
		PushButton.setEnabled(false);
		PopButton.setEnabled(false);
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.VirtualMachine.CPUObserver#onEndRun()
	 */
	@Override
	public void onEndRun() {
		PushButton.setEnabled(true);
		PopButton.setEnabled(true);
		
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
		
		
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.VirtualMachine.StackObserver#onPush(java.lang.Object)
	 */
	@Override
	public void onPush(Integer value) {
		model.addElement(value);
		
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.VirtualMachine.StackObserver#onPop(java.lang.Object)
	 */
	@Override
	public void onPop(Integer value) {
		int pos = model.lastIndexOf(value);
		model.remove(pos);
		
	}

	@Override
	public void onStackReset() {
		model.clear();
		
	}
}

