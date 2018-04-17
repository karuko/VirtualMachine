package tp.pr2.mv.gui.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;

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
 * The Class StatusBarPanel.
 */
@SuppressWarnings("serial")
public class StatusBarPanel extends JPanel implements StackObserver<Integer>, MemoryObserver<Integer>, CPUObserver{

	/** The stack check. */
	private JCheckBox memCheck, stackCheck;
	
	/** The num ins. */
	private int numIns;
	
	/** The stop. */
	private JTextArea text, stop;
	
	/** The table. */
	private JTable table;
	
	/** The Checkpanel. */
	private JPanel Checkpanel;
	
	
	 /**
 	 * Instantiates a new status bar panel.
 	 *
 	 * @param cpu the cpu
 	 * @param stack the stack
 	 * @param memory the memory
 	 */
 	public StatusBarPanel(Observable<CPUObserver> cpu,
			Observable<StackObserver<Integer>> stack,
			Observable<MemoryObserver<Integer>> memory){
		 
		 cpu.addObserver(this);
		 stack.addObserver(this);
		 memory.addObserver(this);
		 initGUI();
	 }
		
	 /**
 	 * Inits the gui.
 	 */
 	private void initGUI(){
		 	
			this.setLayout(new BorderLayout());
			this.setBorder(new TitledBorder("Status Panel"));
			
		    Checkpanel = new JPanel();
			this.add(Checkpanel, BorderLayout.PAGE_END);
			
			text = new JTextArea();
			text.setOpaque(false);		
			text.setText("Num.instrucciones ejecutadas: ");
			text.setFont(new Font("Arial", Font.BOLD, 12));
			
			
			 stop = new JTextArea();
			stop.setOpaque(false);
			stop.setText("Maquina parada");
			stop.setFont(new Font("Arial", Font.BOLD, 12));
			stop.setForeground(Color.RED);
			stop.setVisible(false);
			
			memCheck = new JCheckBox("Memoria modificada");
			memCheck.setSelected(false);
			stackCheck = new JCheckBox("Pila modificada");
			stackCheck.setSelected(false);
			
			
			table = new JTable(1,1);
			table.setOpaque(false);
			((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);
			table.setShowHorizontalLines(false);
			table.setShowVerticalLines(false);
			table.setEnabled(false);
			table.setFont(new Font("Arial", Font.BOLD, 12));
			table.setValueAt(this.numIns, 0, 0);
			
			Checkpanel.add(stop);
			Checkpanel.add(text);
			Checkpanel.add(table);
			Checkpanel.add(memCheck);
			Checkpanel.add(stackCheck);
			
			
		}
	 	
	/* (non-Javadoc)
	 * @see tp.pr2.mv.VirtualMachine.CPUObserver#onStartInstrExecution(tp.pr2.mv.Instructions.Instruction)
	 */
	@Override
	public void onStartInstrExecution(Instruction instr) {
		stackCheck.setSelected(false);
		memCheck.setSelected(false);
		stop.setVisible(false);
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.VirtualMachine.CPUObserver#onEndInstrExecution(int, tp.pr2.mv.VirtualMachine.OperandStack, tp.pr2.mv.VirtualMachine.Memory)
	 */
	@Override
	public void onEndInstrExecution(int pc, OperandStack<Integer> stack, Memory<Integer> memory) {
		
		this.numIns++;
		table.setValueAt(this.numIns, 0 , 0);
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
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.VirtualMachine.CPUObserver#onHalt()
	 */
	@Override
	public void onHalt() {
		stop.setVisible(true);
		
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.VirtualMachine.CPUObserver#onReset(tp.pr2.mv.VirtualMachine.ProgramMv)
	 */
	@Override
	public void onReset(ProgramMv program) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.VirtualMachine.MemoryObserver#onWrite(int, java.lang.Object)
	 */
	@Override
	public void onWrite(int index, Integer value) {
		memCheck.setSelected(true);
		
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.VirtualMachine.StackObserver#onPush(java.lang.Object)
	 */
	@Override
	public void onPush(Integer value) {
		stackCheck.setSelected(true);
		
	}

	/* (non-Javadoc)
	 * @see tp.pr2.mv.VirtualMachine.StackObserver#onPop(java.lang.Object)
	 */
	@Override
	public void onPop(Integer value) {
		stackCheck.setSelected(true);
		
	}

	@Override
	public void onStackReset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMemReset() {
		// TODO Auto-generated method stub
		
	}
	

}
